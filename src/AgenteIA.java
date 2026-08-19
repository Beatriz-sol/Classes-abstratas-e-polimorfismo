public class AgenteIA {

    public void processarPrompt(String prompt)
            throws FalhaProcessamentoAgenteException {

        if (prompt == null || prompt.isEmpty()) {
            throw new FalhaProcessamentoAgenteException(
                "O prompt não pode estar vazio."
            );
        }

        if (prompt.length() > 100) {
            throw new FalhaProcessamentoAgenteException(
                "Prompt muito longo para o modelo atual."
            );
        }

        System.out.println("Agente processando: " + prompt);
    }

    public void verificarSeguranca(String prompt)
            throws PromptInadequadoException {

        if (prompt == null) {
            return;
        }

        String promptMinusculo = prompt.toLowerCase();

        if (promptMinusculo.contains("hackear")
                || promptMinusculo.contains("roubar")) {

            throw new PromptInadequadoException(
                "Prompt bloqueado por conter conteúdo inadequado."
            );
        }
    }

    public void chamarModeloExterno()
            throws ErroComunicacaoIAException {

        double numeroAleatorio = Math.random();

        System.out.println(
            "Tentando comunicação com modelo externo..."
        );

        if (numeroAleatorio > 0.7) {

            throw new ErroComunicacaoIAException(
                "Falha na comunicação com o modelo externo."
            );
        }

        System.out.println(
            "Comunicação com modelo externo realizada com sucesso."
        );
    }
}