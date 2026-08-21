public class AgenteChat extends AgenteIA {

    public AgenteChat(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException {

        conectarServidor();

        if (input == null || input.length() == 0) {
            throw new FalhaProcessamentoAgenteException(
                "O prompt não pode estar vazio."
            );
        }

        String promptMinusculo = input.toLowerCase();

        if (promptMinusculo.contains("senha")
                || promptMinusculo.contains("cpf")
                || promptMinusculo.contains("cartão")) {

            throw new PromptInadequadoException(
                "Prompt bloqueado pelo Safety Guard do agente de chat."
            );
        }

        System.out.println(
            "Agente de Chat " + getNome() +
            " respondendo para: " + input
        );
    }
}