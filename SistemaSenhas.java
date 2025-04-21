import java.util.*;

class Senha {
    private final int numero;

    public Senha(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return String.format("Senha: %03d", numero);
    }
}

public class PainelSenhas {
    private Queue<Senha> filaSenhas = new LinkedList<>();
    private List<Senha> senhasAtendidas = new ArrayList<>();
    private int contadorSenhas = 1;

    public void emitirSenha() {
        Senha novaSenha = new Senha(contadorSenhas++);
        filaSenhas.offer(novaSenha);
        System.out.println("✅ Emitida " + novaSenha);
    }

    public void chamarPaciente() {
        if (filaSenhas.isEmpty()) {
            System.out.println("⚠️ Nenhuma senha disponível para chamada.");
            return;
        }
        Senha chamada = filaSenhas.poll();
        senhasAtendidas.add(chamada);
        System.out.println("🔔 Paciente com " + chamada + ", por favor dirigir-se ao atendimento.");
    }

    public void mostrarHistorico() {
        System.out.println("\n📜 Histórico de senhas atendidas:");
        if (senhasAtendidas.isEmpty()) {
            System.out.println("Nenhuma senha foi chamada ainda.");
        } else {
            for (Senha s : senhasAtendidas) {
                System.out.println(" - " + s);
            }
        }
    }

    public static void main(String[] args) {
        PainelSenhas sistema = new PainelSenhas();
        sistema.emitirSenha();
        sistema.emitirSenha();
        sistema.chamarPaciente();
        sistema.emitirSenha();
        sistema.chamarPaciente();
        sistema.mostrarHistorico();
    }
}
