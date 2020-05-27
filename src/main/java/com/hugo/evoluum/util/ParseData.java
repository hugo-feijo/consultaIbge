package com.hugo.evoluum.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.projection.DadoFormatado;

public class ParseData {
	
	private static Logger LOG = Logger.getLogger(ParseData.class.getName());
	
	public static DadoFormatado municipioToDados(Municipio municipio) {
		LOG.info("... Projetando municipio " + municipio.getNome() + " para dados formatados");
		DadoFormatado dados = new DadoFormatado();

		dados.setNomeMesorregiao(municipio.getMicrorregiao().getMesorregiao().getNome());
		dados.setIdEstado(municipio.getMicrorregiao().getMesorregiao().getUf().getId());
		dados.setSiglaEstado(municipio.getMicrorregiao().getMesorregiao().getUf().getSigla());
		dados.setRegiaoNome(municipio.getMicrorregiao().getMesorregiao().getUf().getRegiao().getNome());
		dados.setNomeCidade(municipio.getNome());
		
		dados.setNomeFormatado(dados.getNomeCidade() + "/" + dados.getSiglaEstado());
		
		return dados;
	}
	
	public static OutputStream dadosFormatadosToCsv(List<DadoFormatado> dados,  OutputStream out) throws IOException {
		LOG.info("... Transformando " + dados.size() + " dados formatados em arquivo formato CSV");
		String header = "idEstado,siglaEstado,regiaoNome,nomeCidade,nomeMesorregiao,nomeFormatado" + "\n";
        
	    out.write(header.getBytes());
	    out.flush();
	    
	    for(int i=0; i<dados.size(); i++) {
	    	StringBuffer str = new StringBuffer();
	    	str.append(dados.get(i).getIdEstado()).append(",")
	    		.append(dados.get(i).getSiglaEstado()).append(",")
	    		.append(dados.get(i).getRegiaoNome()).append(",")
	    		.append(dados.get(i).getNomeCidade()).append(",")
	    		.append(dados.get(i).getNomeMesorregiao()).append(",")
	    		.append(dados.get(i).getNomeFormatado()).append("\n");
	    	out.write(str.toString().getBytes());
	    }
	    
	    out.close();
		return out;
	}

}
