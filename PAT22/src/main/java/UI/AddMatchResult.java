/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import backend.GamesManager;
import backend.PlayerManager;
import backend.TeamManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Gajendran
 */
public class AddMatchResult extends javax.swing.JFrame {

    /**
     * Creates new form AddMatchResult
     */
    public AddMatchResult() throws SQLException, ClassNotFoundException {
        initComponents();

        DefaultComboBoxModel comboMod = new DefaultComboBoxModel(TeamManager.getRHBTeamNames().toArray());
        ReddamTeamSelector.setModel(comboMod);
        DefaultComboBoxModel opComboMod = new DefaultComboBoxModel(TeamManager.getOpponentTeamNames().toArray());
        OpponentComboBox.setModel(opComboMod);

    }

    private void updatePlayerCombo() throws ClassNotFoundException, SQLException {

        String teamName = (String) ReddamTeamSelector.getSelectedItem();
        String teamIDStr = TeamManager.getTeamID(teamName);
        char teamID = teamIDStr.charAt(1);

        DefaultComboBoxModel players1 = new DefaultComboBoxModel();
        DefaultComboBoxModel players2 = new DefaultComboBoxModel();
        DefaultComboBoxModel players3 = new DefaultComboBoxModel();
        DefaultComboBoxModel players4 = new DefaultComboBoxModel();
        DefaultComboBoxModel players5 = new DefaultComboBoxModel();
        DefaultComboBoxModel players6 = new DefaultComboBoxModel();
        DefaultComboBoxModel players7 = new DefaultComboBoxModel();
        DefaultComboBoxModel players8 = new DefaultComboBoxModel();
        DefaultComboBoxModel players9 = new DefaultComboBoxModel();
        DefaultComboBoxModel players10 = new DefaultComboBoxModel();
        DefaultComboBoxModel players11 = new DefaultComboBoxModel();
        DefaultComboBoxModel players12 = new DefaultComboBoxModel();
        DefaultComboBoxModel players13 = new DefaultComboBoxModel();
        DefaultComboBoxModel players14 = new DefaultComboBoxModel();
        DefaultComboBoxModel players15 = new DefaultComboBoxModel();
        players1.addElement("");
        players2.addElement("");
        players3.addElement("");
        players4.addElement("");
        players5.addElement("");
        players6.addElement("");
        players7.addElement("");
        players8.addElement("");
        players9.addElement("");
        players10.addElement("");
        players11.addElement("");
        players12.addElement("");
        players13.addElement("");
        players14.addElement("");
        players15.addElement("");

        String[] names = TeamManager.getTeamPlayerName(teamID);
        for (int i = 0; i < names.length; i++) {
            players1.addElement(names[i]);
            players2.addElement(names[i]);
            players3.addElement(names[i]);
            players4.addElement(names[i]);
            players5.addElement(names[i]);
            players6.addElement(names[i]);
            players7.addElement(names[i]);
            players8.addElement(names[i]);
            players9.addElement(names[i]);
            players10.addElement(names[i]);
            players11.addElement(names[i]);
            players12.addElement(names[i]);
            players13.addElement(names[i]);
            players14.addElement(names[i]);
            players15.addElement(names[i]);

        }
        PlayersWhosScored1.setModel(players1);
        PlayersWhosScored2.setModel(players2);
        PlayersWhosScored3.setModel(players3);
        PlayersWhosScored4.setModel(players4);
        PlayersWhosScored5.setModel(players5);

        playersWhoAssisted1.setModel(players6);
        playersWhoAssisted2.setModel(players7);
        playersWhoAssisted3.setModel(players8);
        playersWhoAssisted4.setModel(players9);
        playersWhoAssisted5.setModel(players10);

        playersWithCards1.setModel(players11);
        playersWithCards2.setModel(players12);
        playersWithCards3.setModel(players13);
        playersWithCards4.setModel(players14);
        playersWithCards5.setModel(players15);
    }

    private String getName(String fullname) {
        Scanner sc = new Scanner(fullname);
        String name = "";
        String surname = "";
        while (sc.hasNext()) {
            name = sc.next();
            surname = sc.next();
        }
        return name;
    }

    private String getSurname(String fullname) {
        Scanner sc = new Scanner(fullname);
        String name = "";
        String surname = "";
        while (sc.hasNext()) {
            name = sc.next();
            surname = sc.next();
        }
        return surname;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        locationCombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PlayersWhosScored1 = new javax.swing.JComboBox<>();
        PlayersWhosScored2 = new javax.swing.JComboBox<>();
        PlayersWhosScored3 = new javax.swing.JComboBox<>();
        PlayersWhosScored4 = new javax.swing.JComboBox<>();
        PlayersWhosScored5 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        playersWhoAssisted1 = new javax.swing.JComboBox<>();
        playersWhoAssisted2 = new javax.swing.JComboBox<>();
        playersWhoAssisted3 = new javax.swing.JComboBox<>();
        playersWhoAssisted4 = new javax.swing.JComboBox<>();
        playersWhoAssisted5 = new javax.swing.JComboBox<>();
        ReddamTeamSelector = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        playersWithCards1 = new javax.swing.JComboBox<>();
        playersWithCards2 = new javax.swing.JComboBox<>();
        playersWithCards3 = new javax.swing.JComboBox<>();
        playersWithCards4 = new javax.swing.JComboBox<>();
        playersWithCards5 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        goals1 = new javax.swing.JSpinner();
        goals2 = new javax.swing.JSpinner();
        goals3 = new javax.swing.JSpinner();
        goals4 = new javax.swing.JSpinner();
        goals5 = new javax.swing.JSpinner();
        assist1 = new javax.swing.JSpinner();
        assist2 = new javax.swing.JSpinner();
        assist3 = new javax.swing.JSpinner();
        assist4 = new javax.swing.JSpinner();
        assist5 = new javax.swing.JSpinner();
        card1 = new javax.swing.JComboBox<>();
        card2 = new javax.swing.JComboBox<>();
        card3 = new javax.swing.JComboBox<>();
        card4 = new javax.swing.JComboBox<>();
        card5 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        opponentGoalsScoerd = new javax.swing.JTextField();
        OpponentComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField6.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Match Result");

        jLabel6.setFont(new java.awt.Font("Gill Sans Nova", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("vs");

        jLabel5.setFont(new java.awt.Font("Gill Sans Nova", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Location");

        locationCombo.setBackground(new java.awt.Color(0, 51, 102));
        locationCombo.setForeground(new java.awt.Color(255, 255, 255));
        locationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Home", "Away", " " }));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reddam"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Gill Sans Nova", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Players who scored");

        PlayersWhosScored1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayersWhosScored1ActionPerformed(evt);
            }
        });

        PlayersWhosScored5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayersWhosScored5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans Nova", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Players who assisted");

        playersWhoAssisted2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersWhoAssisted2ActionPerformed(evt);
            }
        });

        playersWhoAssisted5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersWhoAssisted5ActionPerformed(evt);
            }
        });

        ReddamTeamSelector.setBackground(new java.awt.Color(0, 0, 102));
        ReddamTeamSelector.setForeground(new java.awt.Color(255, 255, 255));
        ReddamTeamSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ReddamTeamSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReddamTeamSelectorActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Gill Sans Nova", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Players who got carded");

        playersWithCards5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersWithCards5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reddam Team");

        card1.setBackground(new java.awt.Color(0, 51, 102));
        card1.setForeground(new java.awt.Color(255, 255, 255));
        card1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "R" }));

        card2.setBackground(new java.awt.Color(0, 51, 102));
        card2.setForeground(new java.awt.Color(255, 255, 255));
        card2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "R" }));

        card3.setBackground(new java.awt.Color(0, 51, 102));
        card3.setForeground(new java.awt.Color(255, 255, 255));
        card3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "R" }));

        card4.setBackground(new java.awt.Color(0, 51, 102));
        card4.setForeground(new java.awt.Color(255, 255, 255));
        card4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "R" }));

        card5.setBackground(new java.awt.Color(0, 51, 102));
        card5.setForeground(new java.awt.Color(255, 255, 255));
        card5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "R" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(ReddamTeamSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PlayersWhosScored4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayersWhosScored2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayersWhosScored1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayersWhosScored3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayersWhosScored5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goals1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goals2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goals5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goals4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goals3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playersWhoAssisted2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(playersWhoAssisted1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playersWhoAssisted5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(playersWhoAssisted3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playersWhoAssisted4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(assist1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assist5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assist4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assist3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assist2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(playersWithCards1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playersWithCards2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playersWithCards3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playersWithCards4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playersWithCards5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReddamTeamSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goals1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PlayersWhosScored1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playersWhoAssisted1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(assist1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PlayersWhosScored2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goals2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(playersWhoAssisted2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assist2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PlayersWhosScored3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playersWhoAssisted3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(goals3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assist3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PlayersWhosScored4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playersWhoAssisted4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(goals4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assist4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PlayersWhosScored5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(goals5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playersWhoAssisted5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(assist5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playersWithCards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playersWithCards2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playersWithCards3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playersWithCards4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playersWithCards5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opponent"));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        opponentGoalsScoerd.setText("0");
        opponentGoalsScoerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opponentGoalsScoerdActionPerformed(evt);
            }
        });

        OpponentComboBox.setBackground(new java.awt.Color(0, 0, 102));
        OpponentComboBox.setForeground(new java.awt.Color(255, 255, 255));
        OpponentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Opponent Team");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Goals Opponet Scored");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OpponentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(33, 33, 33)
                .addComponent(opponentGoalsScoerd, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(opponentGoalsScoerd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OpponentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(115, 115, 115)
                                .addComponent(locationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(locationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomeScreen Info = null;
        try {
            Info = new HomeScreen();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        Info.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void playersWhoAssisted5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersWhoAssisted5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playersWhoAssisted5ActionPerformed

    private void PlayersWhosScored5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayersWhosScored5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayersWhosScored5ActionPerformed

    private void playersWithCards5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersWithCards5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playersWithCards5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String location = (String) locationCombo.getSelectedItem();
            String RHBTeam = (String) ReddamTeamSelector.getSelectedItem();
            String teamAID = TeamManager.getTeamID(RHBTeam).replace("#", "").replace("\n", "");
            String OpponentTeam = (String) OpponentComboBox.getSelectedItem();
            String teamBID = TeamManager.getTeamID(OpponentTeam).replace("#", "").replace("\n", "");
            int gameID = GamesManager.addGame(location, teamAID, teamBID);
            

            //GOALS
            String fullnameGoal1 = (String) PlayersWhosScored1.getSelectedItem();
            if (fullnameGoal1 != null) {
                String playerGoalID1Str = PlayerManager.getPlayerID(getName(fullnameGoal1), getSurname(fullnameGoal1)).replace("#", "");
                int goal1 = (int) goals1.getValue();
                GamesManager.addGameGoals(gameID, playerGoalID1Str, goal1);
            }

            String fullnameGoal2 = (String) PlayersWhosScored2.getSelectedItem();
            if (fullnameGoal2 != null) {
            String playerGoalID2 = PlayerManager.getPlayerID(getName(fullnameGoal2), getSurname(fullnameGoal2)).replace("#", "");
            int goal2 = (int) goals2.getValue();
            GamesManager.addGameGoals(gameID, playerGoalID2, goal2);
            }
            
            String fullnameGoal3 = (String) PlayersWhosScored3.getSelectedItem();
            if (fullnameGoal3 != null) {
            String playerGoalID3 = PlayerManager.getPlayerID(getName(fullnameGoal3), getSurname(fullnameGoal3)).replace("#", "");
            int goal3 = (int) goals3.getValue();
            GamesManager.addGameGoals(gameID, playerGoalID3, goal3);
            }
            
            String fullnameGoal4 = (String) PlayersWhosScored4.getSelectedItem();
            if (fullnameGoal4 != null) {
            String playerGoalID4 = PlayerManager.getPlayerID(getName(fullnameGoal4), getSurname(fullnameGoal4)).replace("#", "");
            int goal4 = (int) goals4.getValue();
            GamesManager.addGameGoals(gameID, playerGoalID4, goal4);
            }
            
            String fullnameGoal5 = (String) PlayersWhosScored5.getSelectedItem();
            if (fullnameGoal5 != null) {
            String playerGoalID5 = PlayerManager.getPlayerID(getName(fullnameGoal5), getSurname(fullnameGoal5)).replace("#", "");
            int goal5 = (int) goals5.getValue();
            GamesManager.addGameGoals(gameID, playerGoalID5, goal5);
            }
            //ASSISTS
            String fullnameAssist1 = (String) playersWhoAssisted1.getSelectedItem();
            if (fullnameAssist1 != null) {
            String playerAssistID1Str = PlayerManager.getPlayerID(getName(fullnameAssist1), getSurname(fullnameAssist1)).replace("#", "");
            int assist1 = (int) this.assist1.getValue();
            GamesManager.addGameAssists(gameID, playerAssistID1Str, assist1);
            }
            
            String fullnameAssist2 = (String) playersWhoAssisted2.getSelectedItem();
            if (fullnameAssist2 != null) {
            String playerAssistID2Str = PlayerManager.getPlayerID(getName(fullnameAssist2), getSurname(fullnameAssist2)).replace("#", "");
            int assist2 = (int) this.assist2.getValue();
            GamesManager.addGameAssists(gameID, playerAssistID2Str, assist2);
            }
            
            String fullnameAssist3 = (String) playersWhoAssisted3.getSelectedItem();
            if (fullnameAssist3 != null) {
            String playerAssistID3Str = PlayerManager.getPlayerID(getName(fullnameAssist3), getSurname(fullnameAssist3)).replace("#", "");
            int assist3 = (int) this.assist3.getValue();
            GamesManager.addGameAssists(gameID, playerAssistID3Str, assist3);
            }
            
            String fullnameAssist4 = (String) playersWhoAssisted4.getSelectedItem();
            if (fullnameAssist4 != null) {
            String playerAssistID4Str = PlayerManager.getPlayerID(getName(fullnameAssist4), getSurname(fullnameAssist4)).replace("#", "");
            int assist4 = (int) this.assist4.getValue();
            GamesManager.addGameAssists(gameID, playerAssistID4Str, assist4);
            }
            
            String fullnameAssist5 = (String) playersWhoAssisted5.getSelectedItem();
            if (fullnameAssist5 != null) {
            String playerAssistID5Str = PlayerManager.getPlayerID(getName(fullnameAssist5), getSurname(fullnameAssist5)).replace("#", "");
            int assist5 = (int) this.assist5.getValue();
            GamesManager.addGameAssists(gameID, playerAssistID5Str, assist5);
            }
            //CARDS
            String fullnameCard1 = (String) playersWithCards1.getSelectedItem();
            if (fullnameCard1 != null) {
            String playerCards1Str = PlayerManager.getPlayerID(getName(fullnameCard1), getSurname(fullnameCard1)).replace("#", "");
            char card1 = (char) this.card1.getSelectedItem();
            GamesManager.addGameCards(gameID, playerCards1Str, card1);
            }
            
            String fullnameCard2 = (String) playersWithCards2.getSelectedItem();
            if (fullnameCard2 != null) {
            String playerCards2Str = PlayerManager.getPlayerID(getName(fullnameCard2), getSurname(fullnameCard2)).replace("#", "");
            char card2 = (char) this.card2.getSelectedItem();
            GamesManager.addGameCards(gameID, playerCards2Str, card2);
            }
            
            String fullnameCard3 = (String) playersWithCards3.getSelectedItem();
            if (fullnameCard3 != null) {
            String playerCards3Str = PlayerManager.getPlayerID(getName(fullnameCard3), getSurname(fullnameCard3)).replace("#", "");
            char card3 = (char) this.card3.getSelectedItem();
            GamesManager.addGameCards(gameID, playerCards3Str, card3);
            }
            
            String fullnameCard4 = (String) playersWithCards4.getSelectedItem();
            if (fullnameCard4 != null) {
            String playerCards4Str = PlayerManager.getPlayerID(getName(fullnameCard4), getSurname(fullnameCard4)).replace("#", "");
            char card4 = (char) this.card4.getSelectedItem();
            GamesManager.addGameCards(gameID, playerCards4Str, card4);
            }
            
            String fullnameCard5 = (String) playersWithCards5.getSelectedItem();
            if (fullnameCard5 != null) {
            String playerCards5Str = PlayerManager.getPlayerID(getName(fullnameCard5), getSurname(fullnameCard5)).replace("#", "");
            char card5 = (char) this.card5.getSelectedItem();
            GamesManager.addGameCards(gameID, playerCards5Str, card5);
            }
// TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void opponentGoalsScoerdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opponentGoalsScoerdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opponentGoalsScoerdActionPerformed

    private void ReddamTeamSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReddamTeamSelectorActionPerformed
        try {
            updatePlayerCombo();
            // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReddamTeamSelectorActionPerformed

    private void PlayersWhosScored1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayersWhosScored1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayersWhosScored1ActionPerformed

    private void playersWhoAssisted2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersWhoAssisted2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playersWhoAssisted2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddMatchResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMatchResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMatchResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMatchResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddMatchResult().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddMatchResult.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> OpponentComboBox;
    private javax.swing.JComboBox<String> PlayersWhosScored1;
    private javax.swing.JComboBox<String> PlayersWhosScored2;
    private javax.swing.JComboBox<String> PlayersWhosScored3;
    private javax.swing.JComboBox<String> PlayersWhosScored4;
    private javax.swing.JComboBox<String> PlayersWhosScored5;
    private javax.swing.JComboBox<String> ReddamTeamSelector;
    private javax.swing.JSpinner assist1;
    private javax.swing.JSpinner assist2;
    private javax.swing.JSpinner assist3;
    private javax.swing.JSpinner assist4;
    private javax.swing.JSpinner assist5;
    private javax.swing.JComboBox<String> card1;
    private javax.swing.JComboBox<String> card2;
    private javax.swing.JComboBox<String> card3;
    private javax.swing.JComboBox<String> card4;
    private javax.swing.JComboBox<String> card5;
    private javax.swing.JSpinner goals1;
    private javax.swing.JSpinner goals2;
    private javax.swing.JSpinner goals3;
    private javax.swing.JSpinner goals4;
    private javax.swing.JSpinner goals5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JComboBox<String> locationCombo;
    private javax.swing.JTextField opponentGoalsScoerd;
    private javax.swing.JComboBox<String> playersWhoAssisted1;
    private javax.swing.JComboBox<String> playersWhoAssisted2;
    private javax.swing.JComboBox<String> playersWhoAssisted3;
    private javax.swing.JComboBox<String> playersWhoAssisted4;
    private javax.swing.JComboBox<String> playersWhoAssisted5;
    private javax.swing.JComboBox<String> playersWithCards1;
    private javax.swing.JComboBox<String> playersWithCards2;
    private javax.swing.JComboBox<String> playersWithCards3;
    private javax.swing.JComboBox<String> playersWithCards4;
    private javax.swing.JComboBox<String> playersWithCards5;
    // End of variables declaration//GEN-END:variables
}
