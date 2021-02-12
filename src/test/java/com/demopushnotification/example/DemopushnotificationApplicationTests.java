package com.demopushnotification.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demopushnotification.example.model.Mensagem;
import com.demopushnotification.example.service.NotificacoesPushImpl;

@SpringBootTest
class DemopushnotificationApplicationTests {
	
	@Autowired
	private NotificacoesPushImpl notificacoesPush;

	@Test
	void contextLoads() {
		Mensagem mensagem =  new Mensagem();
		mensagem.setTitulo("Titulo teste unitario");
		mensagem.setSubtitulo("SubTitulo teste unitario");
		mensagem.setDescricao("Teste unitario de envio de messagem pelo app onesignal 369");
		String res = notificacoesPush.enviar(mensagem);
		assertEquals("200", res);

	}

}
