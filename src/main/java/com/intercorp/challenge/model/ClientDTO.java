package com.intercorp.challenge.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ClientDTO", description = "Client request")
public class ClientDTO {
	
	@ApiModelProperty(value = "nombre", required = true)
	@NotBlank
	private String name;
	
	@ApiModelProperty(value = "apellido", required = true)
	@NotBlank
	private String lastName;
	
	@ApiModelProperty(value = "edad", required = true)
	@NotEmpty
	@Min(value = 16)
	private int age;
	
	@ApiModelProperty(value = "fecha de nacimiento", required = true, example = "24/12/1984")
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate birthDate;

}
