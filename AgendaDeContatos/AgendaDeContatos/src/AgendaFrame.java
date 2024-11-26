/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Guilherme M
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaFrame extends JFrame {
    private JTextField nomeField, telefoneField, emailField;
    private JButton adicionarButton, editarButton, removerButton, limparButton;
    private JList<String> contatosList;
    private DefaultListModel<String> listModel;

    public AgendaFrame() {
        setTitle("Agenda de Contatos");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // Labels e Campos de Texto
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 80, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 20, 250, 25);
        add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(20, 60, 80, 25);
        add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(100, 60, 250, 25);
        add(telefoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 100, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 100, 250, 25);
        add(emailField);

        // Botões
        adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(20, 140, 100, 25);
        add(adicionarButton);

        editarButton = new JButton("Editar");
        editarButton.setBounds(140, 140, 100, 25);
        add(editarButton);

        removerButton = new JButton("Remover");
        removerButton.setBounds(260, 140, 100, 25);
        add(removerButton);

        // Lista de Contatos
        listModel = new DefaultListModel<>();
        contatosList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(contatosList);
        scrollPane.setBounds(20, 180, 340, 200);
        add(scrollPane);

        // Botão de Limpar
        limparButton = new JButton("Limpar");
        limparButton.setBounds(20, 400, 100, 25);
        add(limparButton);

        // Adicionando funcionalidades aos botões
        addEventListeners();
    }

    private void addEventListeners() {
        // Funcionalidade para adicionar contato
        adicionarButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String telefone = telefoneField.getText().trim();
            String email = emailField.getText().trim();

            if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
                String contato = String.format("Nome: %s | Telefone: %s | Email: %s", nome, telefone, email);
                listModel.addElement(contato);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Funcionalidade para editar contato
        editarButton.addActionListener(e -> {
            int selectedIndex = contatosList.getSelectedIndex();

            if (selectedIndex != -1) {
                String nome = nomeField.getText().trim();
                String telefone = telefoneField.getText().trim();
                String email = emailField.getText().trim();

                if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty()) {
                    String contatoAtualizado = String.format("Nome: %s | Telefone: %s | Email: %s", nome, telefone, email);
                    listModel.set(selectedIndex, contatoAtualizado);
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um contato para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Funcionalidade para remover contato
        removerButton.addActionListener(e -> {
            int selectedIndex = contatosList.getSelectedIndex();

            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um contato para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Funcionalidade para limpar campos e lista
        limparButton.addActionListener(e -> limparCampos());
    }

    private void limparCampos() {
        nomeField.setText("");
        telefoneField.setText("");
        emailField.setText("");
        contatosList.clearSelection();
    }
}