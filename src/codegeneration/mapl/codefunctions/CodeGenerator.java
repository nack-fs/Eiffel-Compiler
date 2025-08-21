package codegeneration.mapl.codefunctions;

import java.io.PrintWriter;
import java.util.stream.Collectors;

import ast.Deftuple;
import ast.datatype.ArrayType;
import ast.datatype.CharacterType;
import ast.datatype.DataType;
import ast.datatype.DoubleType;
import ast.datatype.IntegerType;
import ast.datatype.StructType;
import ast.datatype.VoidType;

public class CodeGenerator {

	private static CodeGenerator instance = null;
    private PrintWriter out;
    private int labelCounter = 0;
    private String sourceFile;
	
	public static enum Scope { GLOBAL, LOCAL, PARAMETER }

    private CodeGenerator() {}

    public static CodeGenerator getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Haz primero initialize()");
        }
        return instance;
    }

    public static void initialize(PrintWriter writer, String sourceFile) {
        if (writer == null) {
            throw new IllegalArgumentException("PrintWriter no puede ser null");
        }
        if (instance == null) {
            instance = new CodeGenerator();
        }
        instance.out = writer;
        instance.sourceFile = sourceFile;
        instance.labelCounter = 0;
    }

    // Generador de etiquetas únicas
    public String nextLabel() {
        return String.format("L%04d", labelCounter++);
    }

    // Imprime una etiqueta en MAPL
    public void printLabel(String label) {
    	out.println(label + ":");
        out.flush();
    }

    // Source para MAPL
    public void source() {
        out.println("#source\t\"" + sourceFile + "\"");
        out.flush();
    }

    // Indica el número de línea en el código MAPL
    public void line(int lineNumber) {
        out.println("\n#line\t" + lineNumber);
        out.flush();
    }
    
    // Etiqueta una función en MAPL
    public void func(String functionName) {
        out.println("#func\t" + functionName);
        out.flush();
    }

    // Etiqueta una variable global en MAPL
    public void global(String name, DataType type, int address) {
    	out.println("#global\t" + name + ":" + getMAPLTypeString(type) + "\t' offset " + address);
        out.flush();
    }

    // Etiqueta un parámetro de una función en MAPL
    public void param(String name, DataType type, int offset) {
    	out.println("#param\t" + name + ":" + getMAPLTypeString(type) + "\t' BP+" + offset);
        out.flush();
    }

    // Etiqueta variables locales en MAPL
    public void local(String name, DataType type, int offset) {
    	out.println("#local\t" + name + ":" + getMAPLTypeString(type) + "\t' BP" + offset);
        out.flush();
    }

    // Metadatos para el return
    public void retMetadata(DataType type) {
    	DataType effectiveType = (type == null) ? new VoidType() : type;
        out.println("#ret\t" + getMAPLTypeString(effectiveType));
        out.flush();
    }

    // Metadatos para las structs
    public void type(Deftuple deftuple) {
    	String fieldsString = deftuple.getFields().stream()
                .map(field -> "\n\t\t" + field.getName() + ":" + getMAPLTypeString(field.getType()) + "\t' offset " + field.getOffset())
                .collect(Collectors.joining());
		out.println("#type\t" + deftuple.getName() + ":{\t" + fieldsString + "\n\t}");
		out.flush();
    }

    // Comentario en MAPL
    public void comment(String commentText) {
    	out.println("\t'\t" + commentText.replace("\n", "\n\t'\t"));
        out.flush();
    }
    

    // ------------ Instrucciones MAPL ------------

    // [PUSH]
    public void pushi(int value) { out.println("\tpushi\t" + value); out.flush(); }
    public void pushf(double value) { out.println("\tpushf\t" + Double.toString(value)); out.flush(); }
    public void pushb(int asciiValue) { out.println("\tpushb\t" + asciiValue); out.flush(); }
    public void pusha(int address) { out.println("\tpusha\t" + address); out.flush(); }
    public void pushBP() { out.println("\tpush\tbp"); out.flush(); }

    // [LOAD]
    public void load(DataType type) {
        String suffix = getMAPLTypeSuffix(type);
        if ("f".equals(suffix)) out.println("\tloadf");
        else if ("b".equals(suffix)) out.println("\tloadb");
        else out.println("\tload");
        out.flush();
    }

    // [STORE]
    public void store(DataType type) {
        String suffix = getMAPLTypeSuffix(type);
        if ("f".equals(suffix)) out.println("\tstoref");
        else if ("b".equals(suffix)) out.println("\tstoreb");
        else out.println("\tstore");
        out.flush();
    }

    // [POP]
    public void pop(DataType type) {
    	String suffix = getMAPLTypeSuffix(type);
        if ("b".equals(suffix)) out.println("\tpopb");
        else if ("f".equals(suffix)) out.println("\tpopf");
        else out.println("\tpop");
        out.flush();
    }

    // [ARITHMETIC]
    public void add(DataType type) { out.println("\tadd" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void sub(DataType type) { out.println("\tsub" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void mul(DataType type) { out.println("\tmul" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void div(DataType type) { out.println("\tdiv" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void mod(DataType type) {
        out.println("\tmodi"); out.flush();
    }
    
    // Auxiliar para calcular direcciones
    public void addi() { out.println("\taddi"); out.flush(); }
    public void muli() { out.println("\tmuli"); out.flush(); }

    // Comparaciones
    public void gt(DataType type) { out.println("\tgt" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void lt(DataType type) { out.println("\tlt" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void ge(DataType type) { out.println("\tge" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void le(DataType type) { out.println("\tle" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void eq(DataType type) { out.println("\teq" + getMAPLTypeSuffixReduced(type)); out.flush(); }
    public void ne(DataType type) { out.println("\tne" + getMAPLTypeSuffixReduced(type)); out.flush(); }

    // Lógico
    public void and() { out.println("\tand"); out.flush(); }
    public void or() { out.println("\tor"); out.flush(); }
    public void not() { out.println("\tnot"); out.flush(); }

    // Comnversiones
    public void convert(DataType from, DataType to) {
        String conv = getConversionInstruction(from, to);
        if (conv != null) {
            String[] instructions = conv.split("\\n\\t");
            for(String instruction : instructions) {
                 out.println("\t" + instruction);
            }
            out.flush();
        }
    }
    
    // Conversiones de MAPL
    public void i2f() { out.println("\ti2f"); out.flush(); }
    public void f2i() { out.println("\tf2i"); out.flush(); }
    public void b2i() { out.println("\tb2i"); out.flush(); }
    public void i2b() { out.println("\ti2b"); out.flush(); }


    // Input/Output
    public void in(DataType type) { out.println("\tin" + getMAPLTypeSuffix(type)); out.flush(); }
    public void out(DataType type) { out.println("\tout" + getMAPLTypeSuffix(type)); out.flush(); }
    public void outb() { out.println("\toutb"); out.flush(); }

    // Saltos
    public void jmp(String label) { out.println("\tjmp\t" + label); out.flush(); }
    public void jz(String label) { out.println("\tjz\t" + label); out.flush(); }
    public void jnz(String label) { out.println("\tjnz\t" + label); out.flush(); }

    // Funciones
    public void call(String functionName) { out.println("\tcall\t" + functionName); out.flush(); }
    public void functionStart(String functionName) { out.println("\n" + functionName + ":"); out.flush(); }
    public void enter(int localBytes) { if (localBytes > 0) { out.println("\tenter\t" + localBytes); out.flush(); } }
    public void ret(int returnBytes, int localBytes, int paramBytes) {
        out.println("\tret\t" + returnBytes + "," + localBytes + "," + paramBytes);
        out.flush();
    }
    
    // [HALT]
    public void halt() { out.println("halt"); out.flush(); }

    // ---------- Auxiliary Methods ---------------
    
    // Devuelve el sufijo para MAPL dado un tipo
    private String getMAPLTypeSuffix(DataType type) {
        if (type instanceof IntegerType) return "i";
        if (type instanceof DoubleType) return "f";
        if (type instanceof CharacterType) return "b";
        throw new IllegalArgumentException("Error in code generation");
    }
    
 // Devuelve el sufijo para MAPL dado un tipo
    private String getMAPLTypeSuffixReduced(DataType type) {
        if (type instanceof IntegerType) return "i";
        if (type instanceof DoubleType) return "f";
        if (type instanceof CharacterType) return "";
        throw new IllegalArgumentException("Error in code generation");
    }

    // Dado un tipo devuelve el nombre que conoce para comentario MAPL
    private String getMAPLTypeString(DataType type) {
         if (type instanceof IntegerType) return "int";
         if (type instanceof DoubleType) return "float";
         if (type instanceof CharacterType) return "char";
         if (type instanceof VoidType) return "void";
         if (type instanceof StructType) return ((StructType) type).getName();
         if (type instanceof ArrayType) {
             ArrayType at = (ArrayType) type;
             return at.getSize() + " * " + getMAPLTypeString(at.getDataType());
         }
         throw new IllegalArgumentException("Error in code generation");
    }

    // Realiza la operación de conversión dados dos tipos
    private String getConversionInstruction(DataType from, DataType to) {
         if (from.getClass().equals(to.getClass())) return null;
         if (from instanceof CharacterType && to instanceof IntegerType) return "b2i";
         if (from instanceof IntegerType && to instanceof DoubleType) return "i2f";
         if (from instanceof DoubleType && to instanceof IntegerType) return "f2i";
         if (from instanceof IntegerType && to instanceof CharacterType) return "i2b";
         if (from instanceof CharacterType && to instanceof DoubleType) return "b2i\n\ti2f";
         if (from instanceof DoubleType && to instanceof CharacterType) return "f2i\n\ti2b";
         throw new IllegalArgumentException("Error in code generation");
    }
    
    // Realiza la operación aritmética en MAPL dado un operador y un tipo
    public void arithmetic(String operator, DataType type) {
        switch (operator) {
            case "+": add(type); break;
            case "-": sub(type); break;
            case "*": mul(type); break;
            case "/": div(type); break;
            case "mod": mod(type); break;
            default:
                 throw new IllegalArgumentException("Operador aritmético desconocido: " + operator);
        }
    }
    
    // Realiza la operación de comparación en MAPL dado un operador y un tipo
    public void comparison(String operator, DataType operandType) {
        switch (operator) {
           case ">": gt(operandType); break;
           case "<": lt(operandType); break;
           case ">=": ge(operandType); break;
           case "<=": le(operandType); break;
           case "=": eq(operandType); break;
           case "<>": ne(operandType); break;
           default:
               throw new IllegalArgumentException("Operador de comparación desconocido: " + operator);
       }
   }
    
    // Realiza la operación de lógica en MAPL dado un operador and o or
    public void logical(String operator) {
        switch (operator) {
            case "and": and(); break;
            case "or": or(); break;
            default:
                 throw new IllegalArgumentException("Operador lógico desconocido: " + operator);
        }
    }
     
     
}