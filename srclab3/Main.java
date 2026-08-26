public class Main {

    public static void main(String[] args) {

        AgenteIA agente = new AgenteChat("GPT-4");

        IAcaoAgente pesquisa = new PluginPesquisaWeb();

        IAcaoAgente geradorCodigo = new PluginGeradorCodigo();

        String comando = "Como aprender Java";

        System.out.println("=== PESQUISA WEB ===");

        try {

            agente.usarHabilidade(
                pesquisa,
                comando
            );

        } catch (PromptInadequadoException e) {

            System.out.println(
                "Erro de segurança: " + e.getMessage()
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "Erro de processamento: " + e.getMessage()
            );
        }

        System.out.println("\n=== GERADOR DE CÓDIGO ===");

        try {

            agente.usarHabilidade(
                geradorCodigo,
                comando
            );

        } catch (PromptInadequadoException e) {

            System.out.println(
                "Erro de segurança: " + e.getMessage()
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "Erro de processamento: " + e.getMessage()
            );
        }

        System.out.println("\n=== TESTE DE SEGURANÇA ===");

        try {

            agente.usarHabilidade(
                pesquisa,
                "hackear"
            );

        } catch (PromptInadequadoException e) {

            System.out.println(
                "Erro de segurança: " + e.getMessage()
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "Erro de processamento: " + e.getMessage()
            );
        }
    }
}