/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegoaleatorio;

/**
 *
 * @author Daimer
 */


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class AdivinaNumeroGUI extends JFrame implements ActionListener {
    private JLabel instrucciones = new JLabel("Introduce un número entre 1 y 100:");
    private JTextField entrada = new JTextField();
    private JButton boton = new JButton("Adivinar");
    private JLabel resultado = new JLabel("");
    private Random random = new Random();
    private int numeroSecreto = random.nextInt(100) + 1;
    private int intentosRestantes = 10;
    
    public AdivinaNumeroGUI() {
        setTitle("Adivina el número");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JLabel("Adivina el número", SwingConstants.CENTER));
        panel.add(instrucciones);
        panel.add(entrada);
        panel.add(boton);
        panel.add(resultado);
        entrada.addActionListener(this);
        boton.addActionListener(this);
        add(panel);
    }
    
    public void actionPerformed(ActionEvent e) {
        int numeroUsuario = Integer.parseInt(entrada.getText());
        intentosRestantes--;
        if (numeroUsuario == numeroSecreto) {
            resultado.setText("¡Correcto! El número secreto era " + numeroSecreto);
            entrada.setEnabled(false);
            boton.setEnabled(false);
        } else if (intentosRestantes == 0) {
            resultado.setText("¡Agotaste tus intentos! El número secreto era " + numeroSecreto);
            entrada.setEnabled(false);
            boton.setEnabled(false);
        } else if (numeroUsuario < numeroSecreto) {
            resultado.setText("Demasiado bajo. Intentos restantes: " + intentosRestantes);
        } else {
            resultado.setText("Demasiado alto. Intentos restantes: " + intentosRestantes);
        }
        entrada.setText("");
        entrada.requestFocus();
    }
    
    public static void main(String[] args) {
        AdivinaNumeroGUI juego = new AdivinaNumeroGUI();
        juego.setVisible(true);
    }
}