package GraphiqueBorne.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import javax.swing.JPanel.*;
// import GraphiqueBorne.controller.ControllerLouer;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import BorneConsole.ParcAuto;
import GraphiqueBorne.controller.Controller;

public class Gui extends JFrame {

    JButton louer = new JButton("Louer");
    JButton retour = new JButton("Retour");
    JButton etatScoot = new JButton("Etat Scooter");
    JButton afficheAll = new JButton("Affiche All");
    JButton quit = new JButton("Quitter");

    public Gui() {
        super("swing app");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        this.setContentPane(contentPane);
        louer.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                contentPane.add(createRightPanel(), BorderLayout.EAST);
                contentPane.add(creatStatusBar(""), BorderLayout.SOUTH);
                contentPane.add(fctLouer(), BorderLayout.CENTER);
                // fctLouer();
                contentPane.updateUI();

            }
        }));
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                contentPane.add(createRightPanel(), BorderLayout.EAST);
                contentPane.add(creatStatusBar(""), BorderLayout.SOUTH);
                contentPane.add(fctRetour(), BorderLayout.CENTER);
                // fctLouer();
                contentPane.updateUI();

            }
        });

        etatScoot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                contentPane.add(createRightPanel(), BorderLayout.EAST);
                contentPane.add(creatStatusBar(""), BorderLayout.SOUTH);
                contentPane.add(fctAfficheStat(), BorderLayout.NORTH);
                // fctAfficheStat();
                contentPane.updateUI();
            }
        });

        afficheAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(creatStatusBar(""), BorderLayout.SOUTH);
        contentPane.add(createRightPanel(), BorderLayout.EAST);

    }

    private JPanel fctRetour() {

        JPanel retour = new JPanel(new GridLayout(2, 1));
        JTextField txtId = new JTextField("id scooter");
        JButton confirm = new JButton("confirm");
        retour.add(txtId);
        retour.add(confirm);
        // retour.add(createRightPanel());
        // this.setContentPane(retour);
        // this.revalidate();

        return retour;
    }

    private JPanel createRightPanel() {
        // init panel + button
        JPanel panel = new JPanel(new GridLayout(5, 1));
        // panel.setLayout(new FlowLayout());
        panel.add(louer);
        panel.add(retour);
        panel.add(etatScoot);
        panel.add(afficheAll);
        panel.add(quit);

        return panel;
    }

    private JPanel creatStatusBar(String S) {
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel(S);
        lblStatus1.setPreferredSize(new Dimension(100, 30));
        statusBar.add(lblStatus1);

        return statusBar;
    }

    private JPanel fctLouer() {
        JPanel pannel = new JPanel(new GridLayout(4, 1, 5, 5));
        JTextField idscoot = new JTextField("id scoot");
        JTextField DateDeb = new JTextField("jj/mm/ann");
        JTextField DateFin = new JTextField("jj/mm/ann");
        JButton louer2 = new JButton("Appuyer pour louer !");
        louer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        pannel.add(idscoot);
        pannel.add(DateDeb);
        pannel.add(DateFin);
        pannel.add(louer2);

        return pannel;
        // pannel.add(createRightPanel());
        // this.setContentPane(pannel);
        // this.revalidate();

    }

    private JPanel fctAfficheStat() {

        JPanel pannel = new JPanel(new GridLayout(2, 1));
        JTextField idRentrer = new JTextField("id scoot");
        JButton chercher = new JButton("chercher !");

        pannel.add(idRentrer);
        pannel.add(chercher);
        return pannel;
        // pannel.add(createRightPanel());
        // this.setContentPane(pannel);
        // this.revalidate();
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException { // le throws est pour le look'n feel
        new ParcAuto();
        UIManager.setLookAndFeel(new NimbusLookAndFeel()); // On peut télécharger des Look'n feel
        new Gui().setVisible(true);
    }
}