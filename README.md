<h1>🏗️ Eiffel (1985) Compiler</h1>
This repository hosts a full-featured compiler for the classic Eiffel 1985 programming language. Developed entirely from scratch, this project serves as both a functional tool and an educational resource, demonstrating the fundamental principles of compiler design. It offers a unique opportunity to explore the inner workings of a language widely recognized for its "Design by Contract" methodology and its focus on software correctness.

<h2>🚀 Key Features</h2>
- Complete Compiler Pipeline: The project covers all core phases of compilation: lexical analysis, parsing, semantic analysis, and intermediate code generation.

- From-Scratch Implementation: Built with a focus on a deep understanding of compiler theory, without relying on pre-existing compiler frameworks (apart from the grammar tools).

- Educational Resource: The modular and well-documented codebase makes it an ideal reference for students and developers interested in compiler construction.

<h2>🛠️ Technology Stack</h2>
This compiler was built using a powerful combination of modern and robust tools:

- **ANTLR 4:** A renowned parser generator used to define the formal language grammar (Grammar.g4). ANTLR automates the creation of the lexer and parser, ensuring accurate tokenization and syntax checking.

- **Vgen:** A utility used to generate the skeleton classes for the Abstract Syntax Tree (AST). By processing a formal abstract grammar, Vgen provided the essential data structures for the semantic analysis phase.

- **Java:** The core logic of the compiler, including the visitor pattern for AST traversal, symbol table management, type checking, and code generation, is implemented entirely in Java.
