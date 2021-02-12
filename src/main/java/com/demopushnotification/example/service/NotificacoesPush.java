package com.demopushnotification.example.service;

import com.demopushnotification.example.model.Mensagem;

public interface NotificacoesPush {
	public String enviar(Mensagem mensagem);
}
