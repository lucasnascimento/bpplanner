package br.com.lnprojetos.bpplanner.repository;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

	@Id
	private String id;
	private String nome;
	private String descricao;
	private String beneficios;
	private String criterios;
	private String areaSolicitante;
	private String areaExecucao;

}
