public class Main {

    public static void main(String[] args) {

        AgenteIA agente = new AgenteTexto("GPT-4");

        String[] prompts = {
            "Explique o que é inteligência artificial.","","Como hackear um sistema?","Como funciona um banco de dados?",null
             };

        for (int i = 0; i < prompts.length; i++) {

            System.out.println("\n=== TESTE " + (i + 1) + " ===");

            try {

                String prompt = prompts[i];

                agente.processarRequisicao(prompt);

                System.out.println("Processamento concluído com sucesso.");

            } catch (PromptInadequadoException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() +
                    "] Erro: " + e.getMessage()
                );

            } catch (FalhaProcessamentoAgenteException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() +
                    "] Erro: " + e.getMessage()
                );

            } catch (ErroComunicacaoIAException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() +
                    "] Erro: " + e.getMessage()
                );

            } finally {

                System.out.println(
                    "[LOG-AGENTE] Finalizando processamento do teste."
                );
            }
        }
    }
}