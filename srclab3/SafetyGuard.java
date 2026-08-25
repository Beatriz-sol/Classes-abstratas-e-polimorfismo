import java.util.ArrayList;
import java.util.List;

public class SafetyGuard {

    public static void processarFila(List<AgenteIA> lista,String comando) {

        for (AgenteIA agente : lista) {

            try {

                agente.processarRequisicao(comando);

            } catch (PromptInadequadoException e) {

                System.out.println("SAFETY GUARD"+ agente.getNome()+ ": " + e.getMessage());

            } catch (FalhaProcessamentoAgenteException e) {

                System.out.println("FALHA"+ agente.getNome()+ ": "+ e.getMessage());

            } catch (ErroComunicacaoIAException e) {

                System.out.println("COMUNICAÇÃO" + agente.getNome() + ": " + e.getMessage());
            }
        }
    }
}