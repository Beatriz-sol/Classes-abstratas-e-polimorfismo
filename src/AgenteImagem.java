public class AgenteImagem extends AgenteIA {

    public AgenteImagem(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException {

        conectarServidor();

        if (input == null || input.length() == 0) {
            throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
        }

        String promptMinusculo = input.toLowerCase();

        if (promptMinusculo.contains("hackear")|| promptMinusculo.contains("roubar")|| promptMinusculo.contains("biométrico")) {

            throw new PromptInadequadoException("Prompt bloqueado pelo Safety Guard.");
        }

        System.out.println("Agente de Imagem " + getNome() +" sintetizando pixels para: " + input);
    }
}