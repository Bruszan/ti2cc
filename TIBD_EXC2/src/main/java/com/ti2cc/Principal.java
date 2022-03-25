package com.ti2cc;

import java.util.*;

public class Principal {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		int id = 0;
		int opc = 0;
		
		Usuario usuario = new Usuario(id, "pablo", "pablo",'M');
		do	{
			System.out.println("Escolha uma opcao:");
			System.out.println("1) Listar");
			System.out.println("2) Inserir");
			System.out.println("3) Excluir");
			System.out.println("4) Atualizar");
			System.out.println("5) Sair");
			
			opc = sc.nextInt();
			
		switch (opc) {
		case 1:
			//Mostrar usuários
			Usuario[] usuarios = dao.getUsuarios();
			System.out.println("==== Mostrar usuários === ");		
			for(int i = 0; i < usuarios.length; i++) {
				System.out.println(usuarios[i].toString());
			}
			break;
		case 2:
			//Inserir um elemento na tabela
			usuario = new Usuario(id, "pablo", "pablo",'M');
			if(dao.inserirUsuario(usuario) == true) {
				System.out.println("Inserção com sucesso -> " + usuario.toString());
			}
			id++;
			break;
		case 3:
			//Excluir usuário
			dao.excluirUsuario(usuario.getCodigo());
			id--;
			break;
		case 4:
			//Atualizar usuário
			usuario.setSenha("nova senha");
			dao.atualizarUsuario(usuario);
			break;
		case 5:		
			System.out.println("Valeu!");
		}
		} while (opc != 5); 
		
		
		//Mostrar usuários do sexo masculino		
		System.out.println("==== Mostrar usuários do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		
/*
		//Mostrar usuários do sexo masculino
		System.out.println("==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		*/
		
		
		
		
		dao.close();
	}
}