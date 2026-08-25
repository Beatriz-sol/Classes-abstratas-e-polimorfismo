public interface IAcaoagente{
	void executar(String comando)
            throws PromptInadequadoException,
                   FalhaProcessamentoAgenteException;	
}