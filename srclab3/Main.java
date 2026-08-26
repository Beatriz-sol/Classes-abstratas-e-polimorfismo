public class Main {

    public static void main(String[] args) {

        AgenteIA agente = new AgenteChat("GPT-4");

        IAcaoAgente pesquisa = new PluginPesquisaWeb();

        IAcaoAgente geradorCodigo = new PluginGeradorCodigo();

        String comando = "Como aprender Java";

        System.out.println("Pesquisa web");


            try {

                String prompt = prompts[i];

                agente.processarRequisicao(prompt);

                System.out.println("Processamento concluído com sucesso.");

            } catch (PromptInadequadoException e) {

                System.out.println("[LOG-AGENTE] [" + e.getTimestamp() +"] Erro: " + e.getMessage());

            } catch (FalhaProcessamentoAgenteException e) {

                System.out.println("[LOG-AGENTE] [" + e.getTimestamp() +"] Erro: " + e.getMessage() );
            } catch (ErroComunicacaoIAException e) {

                System.out.println(
                    "[LOG-AGENTE] [" + e.getTimestamp() +
                    "] Erro: " + e.getMessage()
                );

            } finally {

                System.out.println("[LOG-AGENTE] Finalizando processamento do teste.");
            }

        }
    }
    
}