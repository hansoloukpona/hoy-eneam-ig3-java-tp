/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package universitymanager;

import java.awt.Component;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Hans OLOUKPONA
 */
public class rootFrame extends javax.swing.JFrame {

    /**
     * Creates new form rootFrame
     */
    static DefaultTableModel etudiantModel;
    static DefaultTableModel evaluationModel;
    static DefaultTableModel ueModel;
    static DefaultComboBoxModel forjComboEtu;
    static DefaultComboBoxModel forjComboUE;
    static AutoCompletion jComp2;
    static AutoCompletion jComp3;
    static AutoCompletion jComp4;
    static AutoCompletion jComp5;
    //ListModel four ;
    static final String DB="javaschooltp"; // base de données à exploiter
    static Connection connect=null; // connexion avec la base
    int whatUserDo = 0;
    public rootFrame() {
        initComponents();
        etudiantModifierjButton1.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        etudiantModel = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        evaluationModel = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        ueModel = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        forjComboEtu = new DefaultComboBoxModel(){};
        forjComboUE = new DefaultComboBoxModel(){};
        
        String[] sessionList = {"normale", "rattrapage", "reprise"};
        jComboBox4.removeAllItems();
        for(int i= 0; i < sessionList.length; i++)
        {
            jComboBox4.addItem(sessionList[i]);
        }
        
        String[] semList = {"1", "2", "3", "4", "5", "6", "7", "8"};
        semestreUEjComboBox.removeAllItems();
        for(int i= 0; i < semList.length; i++)
        {
            semestreUEjComboBox.addItem(semList[i]);
        }
                try
                {
                    // connexion à la base
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connect=DriverManager.getConnection("jdbc:mysql://localhost/"+DB,"javatpuser","javatpuser");
                   
                }catch (ClassNotFoundException | SQLException e)
                {
                    //erreur("Erreur lors de la connexion a la base de donnée, " + e,2);
                    //etudiantNomJTextField1.setText("E "+e);
                }
        
        etudiantjTable1.setModel(etudiantModel);
        evaluationjTable2.setModel(evaluationModel);
        uejTable3.setModel(ueModel);
        jComboBox2.setModel(forjComboEtu);
        jComboBox3.setModel(forjComboUE);
        ResultSet etuRS = this.selectionOfEtudiant();
        ResultSet evaRS = this.selectionOfEvaluation();
        ResultSet ueRS = this.selectionOfUE(); 
        try
        {
            int nbColonnes = 0;
            nbColonnes = etuRS.getMetaData().getColumnCount();
            for(int i=1;i<=nbColonnes;i++)
            {
                //etudiantjTable1.setValueAt(RS.getString(i), j, i );
                etudiantjTable1.getColumnModel().getColumn(i-1).setHeaderValue(etuRS.getMetaData().getColumnName(i));
            }
            nbColonnes = evaRS.getMetaData().getColumnCount();
            for(int i=1;i<=nbColonnes;i++)
            {
                //etudiantjTable1.setValueAt(RS.getString(i), j, i );
                evaluationjTable2.getColumnModel().getColumn(i-1).setHeaderValue(evaRS.getMetaData().getColumnName(i));
            }  
            nbColonnes = ueRS.getMetaData().getColumnCount();
            for(int i=1;i<=nbColonnes;i++)
            {
                //etudiantjTable1.setValueAt(RS.getString(i), j, i );
                uejTable3.getColumnModel().getColumn(i-1).setHeaderValue(ueRS.getMetaData().getColumnName(i));
            }  
        }catch ( SQLException e)
        {
            //er
        }
       
        
        toDoChoiceJTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jTabbedPane1.setSelectedIndex(toDoChoiceJTabbedPane1.getSelectedIndex());
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        //AutoCompletion.enable(jComboBox2);
        jComp2 = AutoCompletion.enable(jComboBox2);
        jComp3 = AutoCompletion.enable(jComboBox3);
        jComp4 = AutoCompletion.enable(jComboBox4);
        jComp5 = AutoCompletion.enable(semestreUEjComboBox);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etudiantSexeButtonGroup = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        appNameJLabel1 = new javax.swing.JLabel();
        modifyOrConsultJTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        toDoChoiceJTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        etudiantNomJTextField1 = new javax.swing.JTextField();
        etudiantPrenomJTextField1 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateNaissancejFormattedTextField1 = new javax.swing.JFormattedTextField();
        etudiantModifierjButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        dateEvaluationjTextField2 = new javax.swing.JTextField();
        anneeAcademiquejTextField3 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jSpinner5 = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSpinner3 = new javax.swing.JSpinner();
        intituleJTextField = new javax.swing.JTextField();
        jSpinner4 = new javax.swing.JSpinner();
        semestreUEjComboBox = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        toDoChoiceJTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        etudiantNomJTextField2 = new javax.swing.JTextField();
        etudiantPrenomJTextField2 = new javax.swing.JTextField();
        jRadioButton5 = new javax.swing.JRadioButton();
        jSpinner8 = new javax.swing.JSpinner();
        jSpinner9 = new javax.swing.JSpinner();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateNaissancejFormattedTextField2 = new javax.swing.JFormattedTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        dateEvaluationjTextField3 = new javax.swing.JTextField();
        anneeAcademiquejTextField4 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jSpinner10 = new javax.swing.JSpinner();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jSpinner11 = new javax.swing.JSpinner();
        intituleJTextField1 = new javax.swing.JTextField();
        jSpinner12 = new javax.swing.JSpinner();
        semestreUEjComboBox1 = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        etudiantjTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        evaluationjTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        uejTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Manager");
        setBackground(new java.awt.Color(255, 255, 153));
        setName("University Manager"); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 153));

        appNameJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appNameJLabel1.setText("Gestionnaire De Données");
        appNameJLabel1.setToolTipText("");

        jPanel8.setBackground(new java.awt.Color(255, 255, 153));

        toDoChoiceJTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toDoChoiceJTabbedPane1StateChanged(evt);
            }
        });
        toDoChoiceJTabbedPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toDoChoiceJTabbedPane1PropertyChange(evt);
            }
        });
        toDoChoiceJTabbedPane1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                toDoChoiceJTabbedPane1VetoableChange(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 153));

        etudiantNomJTextField1.setToolTipText("Ex : OLOUKPONA");
        etudiantNomJTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        etudiantNomJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etudiantNomJTextField1ActionPerformed(evt);
            }
        });

        etudiantPrenomJTextField1.setToolTipText("Ex : Richard");

        etudiantSexeButtonGroup.add(jRadioButton3);
        jRadioButton3.setText("M");
        jRadioButton3.setToolTipText("Masculin");
        jRadioButton3.setMinimumSize(new java.awt.Dimension(7, 25));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jSpinner6.setToolTipText("Ex : 19978819");
        jSpinner6.setMinimumSize(new java.awt.Dimension(7, 22));

        jSpinner7.setToolTipText("66101779");
        jSpinner7.setOpaque(false);

        etudiantSexeButtonGroup.add(jRadioButton4);
        jRadioButton4.setText("F");
        jRadioButton4.setToolTipText("Féminin");
        jRadioButton4.setMinimumSize(new java.awt.Dimension(7, 25));

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setText("Annuler");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 204, 102));
        jButton8.setText("Enregistrer");
        jButton8.setToolTipText("");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Formulaire d'inscription Etudiant");

        jLabel22.setText("Matricule : ");

        jLabel23.setText("Nom :");

        jLabel24.setText("Prénom(s) :");

        jLabel25.setText("Téléphone :");

        jLabel26.setText("Sexe :");

        jLabel3.setText("Date de Naissance :");

        dateNaissancejFormattedTextField1.setToolTipText("YYYY-MM-DD");
        dateNaissancejFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateNaissancejFormattedTextField1ActionPerformed(evt);
            }
        });

        etudiantModifierjButton1.setBackground(new java.awt.Color(255, 255, 0));
        etudiantModifierjButton1.setText("Modifier");
        etudiantModifierjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etudiantModifierjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(etudiantModifierjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateNaissancejFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinner7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etudiantPrenomJTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSpinner6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(etudiantNomJTextField1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(8, 8, 8))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etudiantNomJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etudiantPrenomJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNaissancejFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(etudiantModifierjButton1)
                    .addComponent(jButton8))
                .addGap(31, 31, 31))
        );

        toDoChoiceJTabbedPane1.addTab("Etudiant", jPanel9);

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        jComboBox2.setEditable(true);
        jComboBox2.setToolTipText("Selectionner le numero matricule de l'étudiant");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setEditable(true);
        jComboBox3.setToolTipText("Selectionner le numero de l'unité d'Étude");

        dateEvaluationjTextField2.setToolTipText("YYYY-MM-DD");

        anneeAcademiquejTextField3.setToolTipText("YYYY-MM-DD");
        anneeAcademiquejTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeAcademiquejTextField3ActionPerformed(evt);
            }
        });

        jComboBox4.setEditable(true);
        jComboBox4.setToolTipText("Choisir la session de composition");

        jSpinner5.setToolTipText("Entrer la note obtenue par l'étudiant");

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Annuler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 102));
        jButton4.setText("Enregistrer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Formulaire de Note");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel12.setText("Etudiant :");

        jLabel13.setText("UE :");

        jLabel14.setText("Date d'évaluation :");

        jLabel15.setText("Année Academique :");

        jLabel16.setText("Session : ");

        jLabel17.setText("Note :");

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, 194, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox4, 0, 194, Short.MAX_VALUE)
                                    .addComponent(jSpinner5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(anneeAcademiquejTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(dateEvaluationjTextField2, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateEvaluationjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anneeAcademiquejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        toDoChoiceJTabbedPane1.addTab("Evaluation", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        jSpinner3.setToolTipText("Ex : 100");

        intituleJTextField.setToolTipText("Entrer le nom de l'unité d'Étude");

        jSpinner4.setToolTipText("Ex : 6");

        semestreUEjComboBox.setEditable(true);
        semestreUEjComboBox.setToolTipText("Semestre pour lequel compte l'UE");

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setText("Annuler");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 204, 102));
        jButton6.setText("Enregistrer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("                                                                                                        :");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Formulaire d'UE");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setText("Identifiant :");

        jLabel18.setText("Intitulé :");

        jLabel19.setText("Credit :");

        jLabel20.setText("Semestre :");

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(intituleJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(semestreUEjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intituleJTextField)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestreUEjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        toDoChoiceJTabbedPane1.addTab("       UE     ", jPanel3);

        jLabel2.setText("Inserer ou Modifier des Données");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setName(""); // NOI18N
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDoChoiceJTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDoChoiceJTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, Short.MAX_VALUE))
        );

        modifyOrConsultJTabbedPane1.addTab("Modifier", jPanel8);

        jLabel4.setText("Consulter des Données");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setName(""); // NOI18N
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        toDoChoiceJTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toDoChoiceJTabbedPane2StateChanged(evt);
            }
        });
        toDoChoiceJTabbedPane2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toDoChoiceJTabbedPane2PropertyChange(evt);
            }
        });
        toDoChoiceJTabbedPane2.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                toDoChoiceJTabbedPane2VetoableChange(evt);
            }
        });

        etudiantNomJTextField2.setToolTipText("Ex : OLOUKPONA");
        etudiantNomJTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        etudiantNomJTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etudiantNomJTextField2ActionPerformed(evt);
            }
        });

        etudiantPrenomJTextField2.setToolTipText("Ex : Richard");

        etudiantSexeButtonGroup.add(jRadioButton5);
        jRadioButton5.setText("M");
        jRadioButton5.setToolTipText("Masculin");
        jRadioButton5.setMinimumSize(new java.awt.Dimension(7, 25));
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jSpinner8.setToolTipText("Ex : 19978819");
        jSpinner8.setMinimumSize(new java.awt.Dimension(7, 22));

        jSpinner9.setToolTipText("66101779");
        jSpinner9.setOpaque(false);

        etudiantSexeButtonGroup.add(jRadioButton6);
        jRadioButton6.setText("F");
        jRadioButton6.setToolTipText("Féminin");
        jRadioButton6.setMinimumSize(new java.awt.Dimension(7, 25));

        jButton9.setText("Annuler");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Enregistrer");
        jButton10.setToolTipText("");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Recherche d'un Etudiant");

        jLabel28.setText("Matricule : ");

        jLabel29.setText("Nom :");

        jLabel30.setText("Prénom(s) :");

        jLabel31.setText("Téléphone :");

        jLabel32.setText("Sexe :");

        jLabel5.setText("Date de Naissance :");

        dateNaissancejFormattedTextField2.setToolTipText("YYYY-MM-DD");
        dateNaissancejFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateNaissancejFormattedTextField2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateNaissancejFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSpinner9, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(etudiantPrenomJTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSpinner8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                            .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                            .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(etudiantNomJTextField2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(8, 8, 8))
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etudiantNomJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etudiantPrenomJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNaissancejFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(31, 31, 31))
        );

        toDoChoiceJTabbedPane2.addTab("Etudiant", jPanel10);

        jComboBox5.setEditable(true);
        jComboBox5.setToolTipText("Selectionner le numero matricule de l'étudiant");
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setEditable(true);
        jComboBox6.setToolTipText("Selectionner le numero de l'unité d'Étude");

        dateEvaluationjTextField3.setToolTipText("YYYY-MM-DD");

        anneeAcademiquejTextField4.setToolTipText("YYYY-MM-DD");
        anneeAcademiquejTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeAcademiquejTextField4ActionPerformed(evt);
            }
        });

        jComboBox7.setEditable(true);
        jComboBox7.setToolTipText("Choisir la session de composition");

        jSpinner10.setToolTipText("Entrer la note obtenue par l'étudiant");

        jButton11.setText("Annuler");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Enregistrer");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Recherche d'une note");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel34.setText("Etudiant :");

        jLabel35.setText("UE :");

        jLabel36.setText("Date d'évaluation :");

        jLabel37.setText("Année Academique :");

        jLabel38.setText("Session : ");

        jLabel39.setText("Note :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox5, 0, 194, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox7, 0, 194, Short.MAX_VALUE)
                                    .addComponent(jSpinner10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(anneeAcademiquejTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(dateEvaluationjTextField3, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateEvaluationjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anneeAcademiquejTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap())
        );

        toDoChoiceJTabbedPane2.addTab("Evaluation", jPanel6);

        jSpinner11.setToolTipText("Ex : 100");

        intituleJTextField1.setToolTipText("Entrer le nom de l'unité d'Étude");

        jSpinner12.setToolTipText("Ex : 6");

        semestreUEjComboBox1.setEditable(true);
        semestreUEjComboBox1.setToolTipText("Semestre pour lequel compte l'UE");

        jButton14.setText("Annuler");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Enregistrer");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel6.setText("                                                                                                        :");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Recherche d'une Unité d'Étude");

        jLabel41.setText("Identifiant :");

        jLabel42.setText("Intitulé :");

        jLabel43.setText("Credit :");

        jLabel44.setText("Semestre :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(intituleJTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(semestreUEjComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner12, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intituleJTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestreUEjComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton15))
                .addContainerGap())
        );

        toDoChoiceJTabbedPane2.addTab("       UE     ", jPanel11);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDoChoiceJTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDoChoiceJTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, Short.MAX_VALUE))
        );

        modifyOrConsultJTabbedPane1.addTab("Consulter", jPanel5);

        etudiantjTable1.setAutoCreateRowSorter(true);
        etudiantjTable1.setBackground(new java.awt.Color(255, 255, 153));
        etudiantjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        etudiantjTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        etudiantjTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        etudiantjTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etudiantjTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(etudiantjTable1);

        jTabbedPane1.addTab("Etudiant", jScrollPane1);

        evaluationjTable2.setAutoCreateRowSorter(true);
        evaluationjTable2.setBackground(new java.awt.Color(255, 255, 153));
        evaluationjTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        evaluationjTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        evaluationjTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evaluationjTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(evaluationjTable2);

        jTabbedPane1.addTab("Evaluation", jScrollPane2);

        uejTable3.setAutoCreateRowSorter(true);
        uejTable3.setBackground(new java.awt.Color(255, 255, 153));
        uejTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        uejTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        uejTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uejTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(uejTable3);

        jTabbedPane1.addTab("UE", jScrollPane3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(modifyOrConsultJTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(appNameJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(appNameJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyOrConsultJTabbedPane1)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etudiantNomJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etudiantNomJTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etudiantNomJTextField1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        whatUserDo = 0;
        etudiantModifierjButton1.setVisible(false);
        jButton8.setText("Enregistrer");
        jSpinner6.setValue(0);
        etudiantNomJTextField1.setText("");
        etudiantPrenomJTextField1.setText("");
        jSpinner7.setValue(0);
        etudiantSexeButtonGroup.clearSelection();
        dateNaissancejFormattedTextField1.setText("");
        

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void anneeAcademiquejTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeAcademiquejTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeAcademiquejTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        whatUserDo = 0;
        jButton2.setVisible(false);
        jButton4.setText("Enregistrer");
        jComboBox2.setSelectedIndex(-1);
        jComboBox3.setSelectedIndex(-1);
        jSpinner3.setValue(0);
        dateEvaluationjTextField2.setText("");
        anneeAcademiquejTextField3.setText("");
        jComboBox4.setSelectedIndex(-1);
        jSpinner5.setValue(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void toDoChoiceJTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toDoChoiceJTabbedPane1StateChanged
        // TODO add your handling code here:
        //int i = JTabbedPane.indexOfTabComponent(toDoChoiceJTabbedPane);
    }//GEN-LAST:event_toDoChoiceJTabbedPane1StateChanged

    private void toDoChoiceJTabbedPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toDoChoiceJTabbedPane1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoChoiceJTabbedPane1PropertyChange

    private void toDoChoiceJTabbedPane1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_toDoChoiceJTabbedPane1VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoChoiceJTabbedPane1VetoableChange

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        whatUserDo = 0;
        jButton1.setVisible(false);
        jButton6.setText("Enregistrer");
        jSpinner3.setValue(0);
        intituleJTextField.setText("");
        jSpinner7.setValue(0);
        semestreUEjComboBox.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void dateNaissancejFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateNaissancejFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNaissancejFormattedTextField1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(whatUserDo == 0){
            insertionOfUE();
        }else{
            suppressionOfUE();
        }
        jButton5.doClick();
        selectionOfUE();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(whatUserDo == 0){
            insertionOfEvaluation();
        }else{
            suppressionOfEvaluation();
        }
        jButton3.doClick();
        selectionOfEvaluation();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(whatUserDo == 0){
            insertionOfEtudiant();
        }else{
            suppressionOfEtudiant();
        }
        jButton7.doClick();
        selectionOfEtudiant();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void etudiantjTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etudiantjTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            whatUserDo = 1;
            etudiantModifierjButton1.setVisible(true);
            jButton8.setText("Supprimer");
            modifyOrConsultJTabbedPane1.setSelectedIndex(0);
            toDoChoiceJTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex());
            int rowNum = etudiantjTable1.getSelectedRow();
            jSpinner6.setValue(parseInt(etudiantjTable1.getValueAt(rowNum, 0).toString()));
            etudiantNomJTextField1.setText(etudiantjTable1.getValueAt(rowNum, 1).toString());
            etudiantPrenomJTextField1.setText(etudiantjTable1.getValueAt(rowNum, 2).toString());
            jSpinner7.setValue(parseInt(etudiantjTable1.getValueAt(rowNum, 3).toString()));
            if(etudiantjTable1.getValueAt(rowNum, 4).toString().equals("F"))
            {
                jRadioButton4.setSelected(true);
            }else if(etudiantjTable1.getValueAt(rowNum, 4).toString().equals("M"))
            {
                jRadioButton3.setSelected(true);
            }
            dateNaissancejFormattedTextField1.setText(etudiantjTable1.getValueAt(rowNum, 5).toString());
            }

    }//GEN-LAST:event_etudiantjTable1MouseClicked

    private void evaluationjTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluationjTable2MouseClicked
            // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            whatUserDo = 2;
            jButton2.setVisible(true);
            jButton4.setText("Supprimer");
            modifyOrConsultJTabbedPane1.setSelectedIndex(0);
            toDoChoiceJTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex());
            int rowNum = evaluationjTable2.getSelectedRow();
            
                //jComp2.insertString(0, evaluationjTable2.getValueAt(rowNum, 0).toString(), null);
                jComp2.setText(evaluationjTable2.getValueAt(rowNum, 0).toString());
                //jComp3.insertString(0, evaluationjTable2.getValueAt(rowNum, 1).toString(), null);
                jComp3.setText(evaluationjTable2.getValueAt(rowNum, 1).toString());
            
            
            //jSpinner3.setValue();
            dateEvaluationjTextField2.setText(evaluationjTable2.getValueAt(rowNum, 2).toString());
            anneeAcademiquejTextField3.setText(evaluationjTable2.getValueAt(rowNum, 3).toString());
            
                //jComp4.insertString(0, evaluationjTable2.getValueAt(rowNum, 4).toString(), null);
                jComp4.setText(evaluationjTable2.getValueAt(rowNum, 4).toString());
            
            jSpinner5.setValue(parseInt(evaluationjTable2.getValueAt(rowNum, 5).toString()));
        }
    }//GEN-LAST:event_evaluationjTable2MouseClicked

    private void uejTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uejTable3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            whatUserDo = 3;
            jButton1.setVisible(true);
            jButton6.setText("Supprimer");
            modifyOrConsultJTabbedPane1.setSelectedIndex(0);
            toDoChoiceJTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex());
            int rowNum = uejTable3.getSelectedRow();
            jSpinner3.setValue(parseInt(uejTable3.getValueAt(rowNum, 0).toString()));
            intituleJTextField.setText(uejTable3.getValueAt(rowNum, 1).toString());
            jSpinner4.setValue(parseInt(uejTable3.getValueAt(rowNum, 2).toString()));
            jComp5.setText(uejTable3.getValueAt(rowNum, 3).toString());
        }
    }//GEN-LAST:event_uejTable3MouseClicked

    private void etudiantModifierjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etudiantModifierjButton1ActionPerformed
        // TODO add your handling code here:
        modificationOfEtudiant();
    }//GEN-LAST:event_etudiantModifierjButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        modificationOfEvaluation();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modificationOfUE();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void etudiantNomJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etudiantNomJTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etudiantNomJTextField2ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void dateNaissancejFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateNaissancejFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNaissancejFormattedTextField2ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void anneeAcademiquejTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeAcademiquejTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeAcademiquejTextField4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void toDoChoiceJTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toDoChoiceJTabbedPane2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoChoiceJTabbedPane2StateChanged

    private void toDoChoiceJTabbedPane2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toDoChoiceJTabbedPane2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoChoiceJTabbedPane2PropertyChange

    private void toDoChoiceJTabbedPane2VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_toDoChoiceJTabbedPane2VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoChoiceJTabbedPane2VetoableChange

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rootFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rootFrame().setVisible(true);
                
            }
        });
    }
    
    public static ResultSet selectionOfEtudiant(){
        
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbColonnes; // nb de colonnes du ResultSet
        int nbLignes = 0;
        select = "SELECT * FROM `etudiant`;";
        //String[] requestList = {};
        
        try
        {
            S=connect.prepareStatement("SELECT * FROM `etudiant`;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        
                        RS=S.executeQuery(select);
                        // nombre de colonnes
                        nbColonnes=RS.getMetaData().getColumnCount();
                        if(RS.last()){
                            nbLignes = RS.getRow();
                            RS.beforeFirst();
                        }
                        
                        
                        //System.out.println("Résultats obtenus\n\n");
                        int j = 0;
                        forjComboEtu.removeAllElements();
                        etudiantModel.setColumnCount(nbColonnes);
                        etudiantModel.setRowCount(nbLignes);
                        while(RS.next())
                        { // tant qu'il y a une ligne à exploiter
                            forjComboEtu.addElement(RS.getString(1));
                            for(int i=1;i<=nbColonnes;i++)
                            {
                                //etudiantjTable1.setValueAt(RS.getString(i), j, i );
                                etudiantModel.setValueAt(RS.getString(i), j, i-1);
                            }
                            j++;
                        }// ligne suivante
        }catch (SQLException e)
        {
            //erreur("Erreur lors de la selection des étudiants " + e,2);
            //etudiantNomJTextField1.setText("Erreur" + e);
        }
        return RS;
    }
    
    public int getColumnCountEtudiant(){
        
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbColonnes = 0; // nb de colonnes du ResultSet
        select = "SELECT * FROM `etudiant`;";
        
        try
        {
            S=connect.createStatement();
            RS=S.executeQuery(select);
            // nombre de colonnes
            nbColonnes=RS.getMetaData().getColumnCount();
            
        }catch (SQLException e)
        {
        erreur(this, "Erreur lors de la consultation du nombre de colonnes de le table étudiant " + e);
        }
        return nbColonnes; 
    }
    
    public int getRowCountEtudiant(){
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbLignes = 0;
        select = "SELECT * FROM `etudiant`;";
        String[] requestList = {};
        try
        {
            S=connect.createStatement();
            RS=S.executeQuery(select);
            if(RS.last()){
                nbLignes = RS.getRow();
                RS.beforeFirst();
            }
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la consultation du nombre de ligne de le table etudiant : " + e);
        }
        return nbLignes;
    }
    
    
    
    public int insertionOfEtudiant(){
    
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        String sex = "";
        if(jRadioButton3.isSelected()){
            sex = "M";
        }else if(jRadioButton4.isSelected()){
            sex = "F";
        }
        
        String request = "INSERT INTO `etudiant` (`matricule`, `nom`,"
                + " `prenom`, `telephone`, `sexe`, `dateNaissance`)"
                + " VALUES ('" + jSpinner6.getValue() + "', '" + 
                etudiantNomJTextField1.getText() +"', '" + 
                etudiantPrenomJTextField1.getText() +"', '"+ 
                jSpinner7.getValue() +"', '"+ sex +"', '"+ 
                dateNaissancejFormattedTextField1.getText() +"');";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de l'ajout de l'étudiant " + e);
        }
        
        return nbColonnes;
    
    }
    
    public int modificationOfEtudiant()
    {
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        String sex = "";
        if(jRadioButton3.isSelected()){
            sex = "M";
        }else if(jRadioButton4.isSelected()){
            sex = "F";
        }
        
        String request = "UPDATE `etudiant` SET `nom`= '" + 
                etudiantNomJTextField1.getText() +"', `prenom`= '" +
                etudiantPrenomJTextField1.getText() + 
                "', `telephone`= '" + jSpinner7.getValue() + 
                "', `sexe`= '"+ sex + "', `dateNaissance`= '"+ 
                dateNaissancejFormattedTextField1.getText() +
                "' WHERE `matricule`= "+ jSpinner6.getValue() +";";
                
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la modification de l'étudiant " + e);
        }
        
        return nbColonnes;
    }
    
    public int suppressionOfEtudiant()
    {
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "DELETE FROM `etudiant` WHERE `matricule`="+ jSpinner6.getValue() +";";
                
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la suppression de l'étudiant " + e);
        }
        
        return nbColonnes;
    }
    
    
    
    
    public ResultSet selectionOfEvaluation(){
        
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbColonnes = 0; // nb de colonnes du ResultSet
        int nbLignes = 0;
        select = "SELECT * FROM `evaluation`;";
        //String[] requestList = {};
        try
        {
            S=connect.prepareStatement("SELECT * FROM `evaluation`;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        
                        RS=S.executeQuery(select);
                        // nombre de colonnes
                        nbColonnes=RS.getMetaData().getColumnCount();
                        if(RS.last()){
                            nbLignes = RS.getRow();
                            RS.beforeFirst();
                        }
            //System.out.println("Résultats obtenus\n\n");
            int j = 0;
            evaluationModel.setColumnCount(nbColonnes);
                        evaluationModel.setRowCount(nbLignes);
                        while(RS.next())
                        { // tant qu'il y a une ligne à exploiter
                            for(int i=1;i<=nbColonnes;i++)
                            {
                                //etudiantjTable1.setValueAt(RS.getString(i), j, i );
                                evaluationModel.setValueAt(RS.getString(i), j, i-1);
                            }
                            j++;
                        }// ligne suivante
        }catch (SQLException e)
        {
            erreur(this, "Erreur lors de la selection des evaluations " + e);
        }
        return RS;
    }
    
    
    public int getColumnCountEvaluation(){
        
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbColonnes = 0; // nb de colonnes du ResultSet
        select = "SELECT * FROM `evaluation`;";
        
        try
        {
            S=connect.createStatement();
            RS=S.executeQuery(select);
            // nombre de colonnes
            nbColonnes=RS.getMetaData().getColumnCount();
            
        }catch (SQLException e)
        {
            erreur(this, "Erreur lors de la consultation du nombre de colonnes de le table evaluation " + e);
        }
        return nbColonnes; 
    }
    
    public int getRowCountEvaluation(){
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbLignes = 0;
        select = "SELECT * FROM `evaluation`;";
        try
        {
            S=connect.createStatement();
            RS=S.executeQuery(select);
            if(RS.last()){
                nbLignes = RS.getRow();
                RS.beforeFirst();
            }
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la consultation du nombre de ligne de le table evaluation : " + e);
        }
        return nbLignes;
    }
    
    
    
    
    
    
    public int insertionOfEvaluation(){
        
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "INSERT INTO `evaluation`(`matricule`, `idUE`, "
                + "`dateEvaluation`, `anneeAcademique`, `session`, "
                + "`note`) VALUES ('" + 
                separation(jComboBox2.getSelectedItem().toString()) + "', '" + 
                separation(jComboBox3.getSelectedItem().toString()) +"', '" + 
                dateEvaluationjTextField2.getText() +"', '"+ 
                anneeAcademiquejTextField3.getText() +"', '"+ 
                jComboBox4.getSelectedItem().toString() +"', '"+ 
                jSpinner5.getValue() +"');";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de l'ajout de la note d'évaluation " + e);
        }
        
        return nbColonnes;
    }
    
    public int modificationOfEvaluation(){
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "UPDATE `evaluation` SET `dateEvaluation`= '" + 
                dateEvaluationjTextField2.getText() + 
                "', `anneeAcademique`= '"+ 
                anneeAcademiquejTextField3.getText() + 
                "', `note`= '"+ 
                jSpinner5.getValue() + 
                "' WHERE `matricule`= " + 
                parseInt(separation( jComboBox2.getSelectedItem().toString())) + 
                " AND `idUE`= " + 
                parseInt(separation(jComboBox3.getSelectedItem().toString())) + 
                " AND `session`= '"+ 
                jComboBox4.getSelectedItem().toString() +"';";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            erreur(this, request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la modification de la note d'évaluation " + e);
        }
        
        return nbColonnes;
    }
    
    public int suppressionOfEvaluation(){
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "DELETE FROM `evaluation` WHERE `matricule`=" + 
                separation(jComboBox2.getSelectedItem().toString()) + 
                " AND `idUE`=" + 
                separation(jComboBox2.getSelectedItem().toString()) + ";";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la suppression de la note d'évaluation " + e);
        }
        
        return nbColonnes;
    }
    
    
    
    
    public ResultSet selectionOfUE(){
        
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbColonnes = 0; // nb de colonnes du ResultSet
        int nbLignes = 0;
        select = "SELECT * FROM `ue`;";
        //String[] requestList = {};
        try
        {
            S=connect.prepareStatement("SELECT * FROM `ue`;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        
            RS=S.executeQuery(select);
                        // nombre de colonnes
                        nbColonnes=RS.getMetaData().getColumnCount();
                        if(RS.last()){
                            nbLignes = RS.getRow();
                            RS.beforeFirst();
                        }
                        //System.out.println("Résultats obtenus\n\n");
                        int j = 0;
                        forjComboUE.removeAllElements();
                        ueModel.setColumnCount(nbColonnes);
                        ueModel.setRowCount(nbLignes);
                        while(RS.next())
                        { // tant qu'il y a une ligne à exploiter
                            forjComboUE.addElement(RS.getString(1));
                            for(int i=1;i<=nbColonnes;i++)
                            {
                                /*if(i==1){
                                    String ch = RS.getString(i);
                                }*/
                                //etudiantjTable1.setValueAt(RS.getString(i), j, i );
                                ueModel.setValueAt(RS.getString(i), j, i-1);
                            }
                            j++;
                        }// ligne suivante
        }catch (SQLException e)
        {
            erreur(this, "Erreur lors de la selection des ue " + e);
        }
        return RS;
    }
    
    
    public int getColumnCountUE(){
        
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbColonnes = 0; // nb de colonnes du ResultSet
        select = "SELECT * FROM `evaluation`;";
        
        try
        {
            S=connect.createStatement();
            RS=S.executeQuery(select);
            // nombre de colonnes
            nbColonnes=RS.getMetaData().getColumnCount();
            
        }catch (SQLException e)
        {
        erreur(this, "Erreur lors de la consultation du nombre de colonnes de le table ue " + e);
        }
        return nbColonnes; 
    }
    
    public int getRowCountUE(){
        Statement S=null; // objet d'émission des requêtes
        ResultSet RS=null; // table résultat d'une requête
        String select; // texte de la requête SQL select
        int nbLignes = 0;
        select = "SELECT * FROM `ue`;";
        try
        {
            S=connect.createStatement();
            RS=S.executeQuery(select);
            if(RS.last()){
                nbLignes = RS.getRow();
                RS.beforeFirst();
            }
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la consultation du nombre de ligne de le table ue : " + e);
        }
        return nbLignes;
    }
    
    
    
    
    
    
    
    
    public int insertionOfUE(){
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "INSERT INTO `ue` (`idUE`, `intitule`, `credit`, "
                + "`semestre`) VALUES ('" + jSpinner3.getValue() + "', '" + 
                intituleJTextField.getText() +"', '"+ 
                jSpinner4.getValue() +"', '"+ 
                semestreUEjComboBox.getSelectedItem().toString() +"');";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de l'ajout d'une UE : " + e);
        }
        
        return nbColonnes;
    }
    
    public int modificationOfUE(){
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "UPDATE `ue` SET `intitule`= '" + 
                intituleJTextField.getText() + 
                "' ,`credit`= '"+ 
                jSpinner4.getValue() + 
                "' ,`semestre`= '"+ 
                semestreUEjComboBox.getSelectedItem().toString() + 
                "' WHERE `idUE`= " + jSpinner3.getValue() + ";";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la modification d'une UE : " + e);
        }
        
        return nbColonnes;
    }
    
    public int suppressionOfUE(){
        Statement S=null; // objet d'émission des requêtes
        int nbColonnes = 0; 
        
        String request = "DELETE FROM `ue` WHERE `idUE`=" + jSpinner3.getValue() + ";";
            
        try
        {
            // création d'un objet Statement
            S=connect.createStatement();
            nbColonnes = S.executeUpdate(request);
            //Insertion éffectuée
            //pop up avec nombe de colonnes modifiés
        }
        catch (SQLException e)
        {
            erreur(this,"Erreur lors de la modification d'une UE : " + e);
        }
        
        return nbColonnes;
    }
    
    public int getRowCount(ResultSet S){
        int nbLignes = 0;
        try
        {
            if(S.last()){
                nbLignes = S.getRow();
                S.beforeFirst();
            }
        }
        catch (SQLException e)
        {
            erreur(this, "Erreur lors de la modification d'une UE : " + e);
        }
        return nbLignes;
    }
    
    public static void erreur(Component parent ,String msg)
    {
        JOptionPane.showMessageDialog(parent, msg);
    }
    
    public String separation(String chaine)
    {
        String[] table = chaine.split("##");
        return table[0];
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anneeAcademiquejTextField3;
    private javax.swing.JTextField anneeAcademiquejTextField4;
    private javax.swing.JLabel appNameJLabel1;
    private javax.swing.JTextField dateEvaluationjTextField2;
    private javax.swing.JTextField dateEvaluationjTextField3;
    private javax.swing.JFormattedTextField dateNaissancejFormattedTextField1;
    private javax.swing.JFormattedTextField dateNaissancejFormattedTextField2;
    private javax.swing.JButton etudiantModifierjButton1;
    private javax.swing.JTextField etudiantNomJTextField1;
    private javax.swing.JTextField etudiantNomJTextField2;
    private javax.swing.JTextField etudiantPrenomJTextField1;
    private javax.swing.JTextField etudiantPrenomJTextField2;
    private javax.swing.ButtonGroup etudiantSexeButtonGroup;
    private javax.swing.JTable etudiantjTable1;
    private javax.swing.JTable evaluationjTable2;
    private javax.swing.JTextField intituleJTextField;
    private javax.swing.JTextField intituleJTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane modifyOrConsultJTabbedPane1;
    private javax.swing.JComboBox<String> semestreUEjComboBox;
    private javax.swing.JComboBox<String> semestreUEjComboBox1;
    private javax.swing.JTabbedPane toDoChoiceJTabbedPane1;
    private javax.swing.JTabbedPane toDoChoiceJTabbedPane2;
    private javax.swing.JTable uejTable3;
    // End of variables declaration//GEN-END:variables
}
