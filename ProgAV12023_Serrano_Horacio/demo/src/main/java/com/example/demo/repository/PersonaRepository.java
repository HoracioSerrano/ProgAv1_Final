package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
	
	List<Persona> findAllByApellidoOrderById(String apellido);
	
	
	@Query("SELECT p FROM Persona p JOIN p.domicilios d JOIN d.pais pais WHERE pais.nombre = :nombrePais ")
	List<Persona> buscarPorPaisDomicilio(@Param("nombrePais")String nombre);

	
	@Query(nativeQuery=true, value = " SELECT sys_persona.per_id id, sys_persona.per_nombre nombre, sys_persona.per_apellido apellido"
			+ " from sys_persona "
			+ " INNER JOIN sys_domicilio on sys_persona.per_id = sys_domicilio.per_id "
			+ " INNER join sys_pais on sys_domicilio.pai_id = sys_pais.pai_id "
			+ " where sys_pais.pai_nombre= :pais "
			+ " and sys_persona.per_apellido= :apellido ")
			List<Object> buscarPorApellidoYPais(String apellido, String pais);
}
