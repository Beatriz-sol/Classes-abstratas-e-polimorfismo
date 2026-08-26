public interface IAcaoAgente{
	void executar(String comando)
            throws PromptInadequadoException,
                   FalhaProcessamentoAgenteException;	
}