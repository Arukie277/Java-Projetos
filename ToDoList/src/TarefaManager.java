import java.util.ArrayList;
import java.util.List;

public class TarefaManager {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(String titulo) {
        tarefas.add(new Tarefa(titulo));
    }

    public void remover(int index) {
        if (index >= 0 && index < tarefas.size()) {
            tarefas.remove(index);
        }
    }

    public void concluir(int index) {
        if (index >= 0 && index < tarefas.size()) {
            tarefas.get(index).marcarComoConcluida();
        }
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}