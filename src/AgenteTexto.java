public class AgenteTexto extends AgenteIA {

    public AgenteTexto(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException {

        conectarServidor();

        ModuloConexao.validarLink();

        if (input == null || input.length() == 0) {
            throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
        }

        if (input.length() > 500) {
            throw new FalhaProcessamentoAgenteException("Estouro de contexto: o prompt ultrapassa 500 caracteres.");
        }

        System.out.println("Agente de Texto " + getNome() +" gerando resposta para: " + input);
    }
}