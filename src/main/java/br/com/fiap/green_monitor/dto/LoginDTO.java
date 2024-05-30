package br.com.fiap.green_monitor.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(

    @NotBlank(message = "Email é obrigatório") String email,

    @NotBlank(message = "Senha é obrigatória") String senha) {

}
