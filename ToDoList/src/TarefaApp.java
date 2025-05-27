import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TarefaApp extends JFrame {
    private TarefaManager manager = new TarefaManager();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> tarefaLista = new JList<>(listModel);
    private JTextField inputTarefa = new JTextField(20);

    public TarefaApp() {
        super("Gerenciador de Tarefas");

        JButton adicionarBtn = new JButton("Adicionar");
        JButton concluirBtn = new JButton("Concluir");
        JButton removerBtn = new JButton("Remover");

        JPanel panel = new JPanel();
        panel.add(inputTarefa);
        panel.add(adicionarBtn);
        panel.add(concluirBtn);
        panel.add(removerBtn);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(tarefaLista), BorderLayout.CENTER);

        adicionarBtn.addActionListener(e -> {
            String titulo = inputTarefa.getText().trim();
            if (!titulo.isEmpty()) {
                manager.adicionar(titulo);
                atualizarLista();
                inputTarefa.setText("");
            }
        });

        concluirBtn.addActionListener(e -> {
            int index = tarefaLista.getSelectedIndex();
            manager.concluir(index);
            atualizarLista();
        });

        removerBtn.addActionListener(e -> {
            int index = tarefaLista.getSelectedIndex();
            manager.remover(index);
            atualizarLista();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    private void atualizarLista() {
        listModel.clear();
        for (Tarefa t : manager.getTarefas()) {
            listModel.addElement(t.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TarefaApp::new);
    }
}