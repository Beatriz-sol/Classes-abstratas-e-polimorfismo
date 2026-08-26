public class PluginGeradorCodigo implements IAcaoAgente {

    @Override
    public void executar(String comando)
            throws PromptInadequadoException,
                   FalhaProcessamentoAgenteException {

        if (comando.length() > 50) {

            throw new FalhaProcessamentoAgenteException(
                "Comando muito longo para geração de código."
            );
        }

        System.out.println(
            "Snippet de código Java gerado para: " + comando
        );
    }
}