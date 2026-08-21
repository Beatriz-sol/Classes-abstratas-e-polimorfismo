public class ValidadorAgente {

    public static void main(String[] args) {

        AgenteIA meuAgente = new AgenteTexto("GPT-4");

        int testesPassados = 0;

        System.out.println(
            "=== INICIANDO VALIDAÇÃO DO AGENTE DE TEXTO ==="
        );

        // Teste 1 - Prompt vazio
        try {

            System.out.print("Teste 1 (Prompt Vazio): ");

            meuAgente.processarRequisicao("");

            System.err.println(
                "FALHA: O agente aceitou um prompt vazio!"
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "SUCESSO: Exceção capturada - "
                + e.getMessage()
            );

            testesPassados++;

        } catch (PromptInadequadoException e) {

            System.out.println(
                "FALHA: Exceção inesperada - "
                + e.getMessage()
            );

        } catch (ErroComunicacaoIAException e) {

            System.out.println(
                "FALHA: Erro de comunicação - "
                + e.getMessage()
            );
        }

        // Teste 2 - Prompt muito longo
        try {

            System.out.print("Teste 2 (Prompt Longo): ");

            String longo = "A".repeat(501);

            meuAgente.processarRequisicao(longo);

            System.err.println(
                "FALHA: O agente aceitou um prompt acima de 500 caracteres!"
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "SUCESSO: Exceção capturada - "
                + e.getMessage()
            );

            testesPassados++;

        } catch (PromptInadequadoException e) {

            System.out.println(
                "FALHA: Exceção inesperada - "
                + e.getMessage()
            );

        } catch (ErroComunicacaoIAException e) {

            System.out.println(
                "FALHA: Erro de comunicação - "
                + e.getMessage()
            );
        }

        // Teste 3 - Prompt válido
        try {

            System.out.print("Teste 3 (Prompt Válido): ");

            meuAgente.processarRequisicao(
                "Explique o que é inteligência artificial."
            );

            System.out.println(
                "SUCESSO: Prompt processado corretamente."
            );

            testesPassados++;

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "FALHA: " + e.getMessage()
            );

        } catch (PromptInadequadoException e) {

            System.out.println(
                "FALHA: " + e.getMessage()
            );

        } catch (ErroComunicacaoIAException e) {

            System.out.println(
                "FALHA: " + e.getMessage()
            );
        }

        System.out.println(
            "\n=== RESULTADO FINAL: "
            + testesPassados
            + "/3 Testes Passados ==="
        );

        if (testesPassados == 3) {

            System.out.println(
                "AGENTE DE TEXTO VALIDADO COM SUCESSO!"
            );
        }
    }
}