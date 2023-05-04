
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "MathMaster";

        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".math");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);

            }
        });
        Functions.setLineNumberOnJTextComponent(jtaOutputConsole);
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"computadora", "mouse", "pantalla"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jtpCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jtpCode);

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Dark Mode");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(7, 7, 7)
                        .addComponent(btnAbrir)
                        .addGap(7, 7, 7)
                        .addComponent(btnGuardar)
                        .addGap(7, 7, 7)
                        .addComponent(btnGuardarC)
                        .addGap(7, 7, 7)
                        .addComponent(btnCompilar)
                        .addGap(7, 7, 7)
                        .addComponent(btnEjecutar)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1))
                    .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(rootPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        cambioColor();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    public void cambioColor() {

        if (jCheckBox1.isSelected()) {
            tblTokens.setForeground(Color.white);
            jtaOutputConsole.setForeground(Color.WHITE);
            jtaOutputConsole.setBackground(new Color(77, 77, 77));
            tblTokens.setBackground(new Color(77, 77, 77));
            rootPanel.setBackground(new Color(0, 0, 0));
            jtpCode.setBackground(new Color(77, 77, 77));
            jCheckBox1.setForeground(Color.white);
        } else {
            tblTokens.setForeground(Color.BLACK);
            jtaOutputConsole.setForeground(Color.BLACK);
            jtaOutputConsole.setBackground(new Color(240, 240, 240));
            tblTokens.setBackground(new Color(240, 240, 240));
            rootPanel.setBackground(new Color(240, 240, 240));
            jtpCode.setBackground(new Color(240, 240, 240));
            jCheckBox1.setForeground(Color.BLACK);
        }

    }

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        /* errores*/
        gramatica.delete(new String[]{"ERROR1", "ERROR2"}, 1);

        // gramatica para variables de tipo numerico entero
        gramatica.group("VARIABLES_ENTERAS", " DATO_ENTERO IDENTIFICADOR OP_ASIGNACION NUMERO ", true, identProd);
        gramatica.group("VARIABLES_ENTERAS", " IDENTIFICADOR OP_ASIGNACION NUMERO", true, 2, "Error sintactico >>  tipo de dato equivocado o faltante en la variable [#,%]");
        gramatica.group("VARIABLES_ENTERAS", " DATO_ENTERO OP_ASIGNACION NUMERO", true, 2, "Error sintactico >> falta el identificador en la variable [#,%]");
        gramatica.group("VARIABLES_ENTERAS", " DATO_ENTERO IDENTIFICADOR NUMERO", true, 2, "Error sintactico >> falta el opeerador de asignacion en la variable [#,%]");
        gramatica.group("VARIABLES_ENTERAS", " DATO_ENTERO IDENTIFICADOR OP_ASIGNACION ", true, 2, "Error sintactico >> falta asignar un valor (o valor invalido) en la variable [#,%]");

        //declaracion para tomar como error la declaracion de dato entero y numero
        gramatica.delete("DATO_ENTERO", 5, "Error sintactico {}: el tipo de dato no esta en una declaracion");
        gramatica.delete("NUMERO", 5, "Error sintactico {}: el valor debe estar en una declaracion");

        // gramatica para variables de tipo numerico decimal
        gramatica.group("VARIABLES_DECIMAL", " DATO_DECIMAL IDENTIFICADOR OP_ASIGNACION DECIMAL ", true, identProd);
        gramatica.group("VARIABLES_DECIMAL", " IDENTIFICADOR OP_ASIGNACION DECIMAL", true, 3, "Error sintactico >>  tipo de dato equivocado o faltante en la variable [#,%]");
        gramatica.group("VARIABLES_DECIMAL", " DATO_DECIMAL OP_ASIGNACION DECIMAL", true, 3, "Error sintactico >> falta el identificador en la variable [#,%]");
        gramatica.group("VARIABLES_DECIMAL", " DATO_DECIMAL IDENTIFICADOR DECIMAL", true, 3, "Error sintactico >> falta el opeerador de asignacion en la variable [#,%]");
        gramatica.group("VARIABLES_DECIMAL", " DATO_DECIMAL IDENTIFICADOR OP_ASIGNACION ", true, 3, "Error sintactico >> falta asignar un valor a la variable [#,%]");

        //reglas para tomar como error las delcaraciones individuales de dato deccimal y decimal
        gramatica.delete("DATO_DECIMAL", 5, "Error sintactico {}: El tipo de dato no esta en una declaracion");
        gramatica.delete("DECIMAL", 5, "Error sintactico {}: el valor debe estar en una declaracion");

        //gramatica para variables de tipo texto
        gramatica.group("VARIABLES_TEXTO", "DATO_TEXTO IDENTIFICADOR OP_ASIGNACION CADENA_DE_TEXTO", true, identProd);
        gramatica.group("VARIABLES_TEXTO", " IDENTIFICADOR OP_ASIGNACION CADENA_DE_TEXTO", true, 4, "Error sintactico >>  tipo de dato equivocado o faltante en la variable [#,%]");
        gramatica.group("VARIABLES_TEXTO", " DATO_TEXTO OP_ASIGNACION CADENA_DE_TEXTO", true, 4, "Error sintactico >> falta el identificador en la variable [#,%]");
        gramatica.group("VARIABLES_TEXTO", " DATO_TEXTO IDENTIFICADOR CADENA_DE_TEXTO", true, 4, "Error sintactico >> falta el opeerador de asignacion en la variable [#,%]");
        gramatica.group("VARIABLES_TEXTO", " DATO_TEXTO IDENTIFICADOR OP_ASIGNACION ", true, 4, "Error sintactico >> falta asignar un valor a la variable [#,%]");

        //declaracion para tomar en cuenta como error la declaracion individual de dato texto y cadena texto
        gramatica.delete("DATO_TEXTO", 5, "Error sintactico {}: el tipo de dato no esta en una declaracion");
        gramatica.delete("CADENA_DE_TEXTO", 5, "Error sintactico {}: la cadena de texto debe estar en una declaracion");

        //declaracion para tomar en cuenta como error la declaraccion del identificador y op de asignacion de forma individual
        gramatica.delete("OP_ASIGNACION", 5, "Error sintactico {}: el operador de asignacion debe estar en una declaracion");
        gramatica.delete("IDENTIFICADOR", 5, "Error sintactico {}: el identificador no esta en una declaracion");

        gramatica.group("VALOR", "IDENTIFICADOR", true);
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+ ");

        //agrupar funciones
        gramatica.group("FUNCION", "suma | resta | multiplicacion | division | tablaMultiplicar | areaCuadrado | areaRectangulo | perimetroCirculo |\n"
                + "convertirUnidades | problemasMatematicos | porcentaje | maximoComunDivisor | minimoComunMultiplo | areaTriangulo", true);

        //creando la estructura completa de una funcion
        gramatica.group("COM_FUNCION", "FUNCION PARENTESIS_ABIERTO (VALOR | PARAMETROS)? PARENTESIS_CERRADO", true);
        gramatica.group("COM_FUNCION", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_CERRADO", 6, "Error sintactico {}: Le ha faltado la apertura del parrentesis");

        gramatica.finalLineColumn();
        gramatica.group("COM_FUNCION", "FUNCION PARENTESIS_ABIERTO (VALOR |PARAMETROS)? ", 6, "Error sintactico {}: Te has olvidado de cerrar el parrentesis");
        gramatica.initialLineColumn();

        //eliminado declaracion incorrectas
        gramatica.delete("FUNCION", 7, "Error sintactico : La funcion no esta siendo usada ene l contexto adecuado [#,%]");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXPRESION_LOGICA", "(COM_FUNCION | EXPRESION_LOGICA) (OPERADOR_LOGICO (COM_FUNCION | EXPRESION_LOGICA))+");
            gramatica.group("EXPRESION_LOGICA", "PARENTESIS_ABIERTO (EXPRESION_LOGICA | COM_FUNCION) PARENTESIS_CERRADO");

        });

        //eliminando operadores logicos
        gramatica.delete("OPERADOR_LOGICO", 8, "Error sintactico: el operador logico no esta contenido en una expresion eliminelo");

        gramatica.group("VALOR", "EXPRESION_LOGICA");
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        //agrupacion estructuras de control
        gramatica.group("ESTRUC_CONTROL", "ESTRUCTURAS_CONTROL ");
        gramatica.group("ESTRUC_CON_COM", "ESTRUC_CONTROL PARENTESIS_ABIERTO PARENTESIS_CERRADO");
        gramatica.group("ESTRUC_CONTROL", "ESTRUC_CONTROL (VALOR | PARAMETROS)");
        gramatica.group("ESTRUC_CON_COM", "ESTRUC_CONTROL PARENTESIS ABIERTO (VALOR | PARAMETROS) PARENTESIS_CERRADO");

        //ERRORES
        gramatica.group("ESTRUC_CON_COM", "ESTRUC_CONTROL (VALOR | PARAMETROS) PARENTESIS_CERRADO", 9, "Error sintactico {}: falta parentesis abierto");
        gramatica.group("ESTRUC_CON_COM", "ESTRUC_CONTROL PARENTESIS ABIERTO (VALOR | PARAMETROS) ", 9, "Error sintactico {}: falta parentesis cerrado");

        //incompletas
        gramatica.delete("ESTRUC_CONTROL", 10, "Error sintactico {}: la estructura no esta completa [#,%]");

        gramatica.finalLineColumn();
        gramatica.group("VARIABLE_GLOBAL", "(VARIABLES_ENTERAS | VARIABLES_DECIMAL | VARIABLES_TEXTO) PUNTO_COMA ");
        gramatica.group("VARIABLE_GLOBAL", "(VARIABLES_ENTERAS | VARIABLES_DECIMAL | VARIABLES_TEXTO)", true, 11, "Error te falta agregar el punto y coma [#,%]");

        gramatica.group("FUNCION_COM_GLOBAL", "COM_FUNCION PUNTO_COMA");
        gramatica.group("FUNCION_COM_GLOBAL", "COM_FUNCION", true, 12, "Error te falta agregar un punto y coma al final de la expresion [#,%]");
        gramatica.initialLineColumn();

        gramatica.delete("PUNTO_COMA", 13, "Error {}: el punto y coma no esta al final de una sentencia [#,%]");
        gramatica.group("SENTENCIAS", "(VARIABLE_GLOBAL | FUNCION_COM_GLOBAL)+");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("ESTRUC_CON_COM_LL", "ESTRUC_CON_COM LLAVE_ABIERTA (SENTENCIAS)? LLAVE_CERRADA", true);
            gramatica.group("SENTENCIAS", "(SENTENCIAS | ESTRUC_CON_COM_LL)+");

        });

        //ESTRUCTURAS INCOMPLETAS FUNCIOENS
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();
            gramatica.group("ESTRUC_CON_COM_LL", "ESTRUC_CON_COM (SENTENCIAS)? LLAVE_CERRADA", true, 14, "Error sintactico {}: falta la llave de apertura [#,%]");
            gramatica.group("ESTRUC_CON_COM_LL", "ESTRUC_CON_COM LLAVE_ABIERTA (SENTENCIAS)? ", true, 14, "Error sintactico {}: falta la llave que cierra [#,%]");

            gramatica.group("SENTENCIAS", "(SENTENCIAS | ESTRUC_CON_COM_LL");

        });

        gramatica.delete(new String[]{"LLAVE_ABIERTA", "LLAVE_CERRADA"}, 15, "Error sintactico {}: la llave [] no esta contenida en ninguna agrupacion [#,%]");

        gramatica.show();
    }

    private void semanticAnalysis() {

        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("DATO_ENTERO", "NUMERO");
        identDataType.put("DATO_TEXTO", "cadena");
        identDataType.put("DATO_DECIMAL", "decimal");
        for (Production id : identProd) {
            if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {

                errors.add(new ErrorLSSL(1, "VALORES NO COMPATIBLES ERROR SEMANTICO", id, true));

            }else if(id.lexicalCompRank(-1).equals("DATO_ENTERO") && !id.lexemeRank(-1).matches("0 | [1-9][0-9]*")){
                
                 errors.add(new ErrorLSSL(1, "VALORES NO COMPATIBLES ERROR SEMANTICO", id, false));
                
            }else{
                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
            }
        }
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
