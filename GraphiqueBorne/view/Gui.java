package GraphiqueBorne.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import javax.swing.JPanel.*;
// import GraphiqueBorne.controller.ControllerLouer;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import BorneConsole.ParcAuto;
import GraphiqueBorne.controller.Controller;
import GraphiqueBorne.model.Scooter;

public class Gui extends JFrame {

    JButton louer = new JButton("Louer");
    JButton retour = new JButton("Retour");
    JButton etatScoot = new JButton("Etat Scooter");
    JButton afficheAll = new JButton("Affiche All");
    JButton quit = new JButton("Quitter");

    public Gui() throws IOException {
        super("swing app");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        this.setContentPane(contentPane);
        louer.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                louerActualise("");
            }
        }));
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retourActualise("");

            }
        });

        etatScoot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EtatActualise("");
            }
        });

        afficheAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AfficheAllActualise("");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(new JLabel("Scooter dispo actuellement :"), BorderLayout.NORTH);
        contentPane.add(afficheAll(Controller.chgtDonne()), BorderLayout.CENTER);
        // Voir pour rajouter une scrollbar
        // JScrollBar scrollBVertical = new JScrollBar(JScrollBar.VERTICAL, 10, 60, 0,
        // 100);
        // contentPane.add(scrollBVertical, BorderLayout.EAST);
        contentPane.add(creatStatusBar(""), BorderLayout.SOUTH);
        contentPane.add(createRightPanel(), BorderLayout.EAST);

    }

    private void louerActualise(String s) {
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.removeAll();
        contentPane.add(createRightPanel(), BorderLayout.EAST);
        contentPane.add(creatStatusBar(s), BorderLayout.SOUTH);
        contentPane.add(fctLouer(), BorderLayout.CENTER);
        // fctLouer();
        contentPane.updateUI();
    }

    private void retourActualise(String s) {
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.removeAll();
        contentPane.add(createRightPanel(), BorderLayout.EAST);
        contentPane.add(creatStatusBar(s), BorderLayout.SOUTH);
        contentPane.add(fctRetour(), BorderLayout.CENTER);
        // fctRetour();
        contentPane.updateUI();
    }

    private void EtatActualise(String s) {
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.removeAll();
        contentPane.add(createRightPanel(), BorderLayout.EAST);
        contentPane.add(creatStatusBar(s), BorderLayout.SOUTH);
        contentPane.add(fctAfficheStat(), BorderLayout.NORTH);
        // fctAfficheStat();
        contentPane.updateUI();
    }

    private void EtatActualiseEtDonne(Scooter s) {
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.removeAll();
        contentPane.add(createRightPanel(), BorderLayout.EAST);
        contentPane.add(fctAfficheStat(), BorderLayout.NORTH);
        contentPane.add(AfficheDonne(s), BorderLayout.CENTER);
        // fctAfficheStat();
        contentPane.updateUI();
    }

    private void AfficheAllActualise(String s) throws IOException {
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.removeAll();
        contentPane.add(new JLabel("Scooter dispo actuellement :"), BorderLayout.NORTH);
        contentPane.add(afficheAll(Controller.btnafficheAllScoot()), BorderLayout.CENTER);
        contentPane.add(creatStatusBar(s), BorderLayout.SOUTH);
        contentPane.add(createRightPanel(), BorderLayout.EAST);
        contentPane.updateUI();
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

    public static JPanel creatStatusBar(String S) {
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel(S);
        statusBar.add(lblStatus1);

        return statusBar;
    }

    private JPanel fctLouer() {
        JPanel pannel = new JPanel(new GridLayout(4, 1, 5, 5));
        JTextField idscoot = new JTextField("id scoot");
        JTextField DateDeb = new JTextField("jj/mm/ann");
        JTextField DateFin = new JTextField("jj/mm/ann");
        Controller ctr = new Controller(idscoot, DateDeb, DateFin);
        JButton louer2 = new JButton("Appuyer pour louer !");
        louer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    louerActualise(Controller.btnLouer(e));

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
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

    private JPanel fctAfficheStat() {

        JPanel pannel = new JPanel(new GridLayout(2, 1));
        JTextField idRentrer = new JTextField("id scoot");
        JButton chercher = new JButton("chercher !");
        Controller ctr = new Controller(idRentrer);
        chercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Scooter rslt = Controller.btnetatScoot();
                if (rslt != null) {
                    EtatActualiseEtDonne(rslt);
                } else {
                    EtatActualise("Id invalide");
                }
            }
        });
        pannel.add(idRentrer);
        pannel.add(chercher);
        return pannel;
        // pannel.add(createRightPanel());
        // this.setContentPane(pannel);
        // this.revalidate();
    }

    private JPanel AfficheDonne(Scooter s) {
        JPanel pannel = new JPanel(new GridLayout(5, 1));
        pannel.add(new JLabel("id Scooter : " + s.getId()));
        pannel.add(new JLabel("Marque: " + s.getMarque()));
        pannel.add(new JLabel("Modéle " + s.getModele()));
        pannel.add(new JLabel("kilométrage :" + s.getKilometrage()));
        if (s.isDispoActual()) {
            pannel.add(new JLabel("Ce scooter est actuellement disponible"));
        } else {
            pannel.add(new JLabel("Ce scooter est actuellement indisponible"));
        }
        return pannel;
    }

    private JPanel afficheAll(ArrayList<Scooter> tabScooterDispo) {
        int n = tabScooterDispo.size();
        JPanel affiche = new JPanel(new GridLayout(n, 4));
        for (Scooter s : tabScooterDispo) {
            affiche.add(new JLabel("id Scooter : " + s.getId()));
            affiche.add(new JLabel("Marque: " + s.getMarque()));
            affiche.add(new JLabel("Modéle " + s.getModele()));
            affiche.add(new JLabel("kilométrage :" + s.getKilometrage()));
        }
        return affiche;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException { // le throws est pour
                                                                                                 // le look'n feel
        // new ParcAuto();
        UIManager.setLookAndFeel(new NimbusLookAndFeel()); // On peut télécharger des Look'n feel
        new Gui().setVisible(true);
    }
}