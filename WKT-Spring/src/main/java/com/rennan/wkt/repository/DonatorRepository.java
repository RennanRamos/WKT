package com.rennan.wkt.repository;

import com.rennan.wkt.domain.Donator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DonatorRepository extends JpaRepository<Donator, Long> {

    @Query("SELECT d FROM Donator d WHERE d.cpf = :cpf")
    Optional<Boolean> findByCPF(String cpf);

    @Query("SELECT COUNT(d.estado) FROM Donator d WHERE d.estado = :estado")
    Integer findByStates(String estado);

    List<Donator> searchAllBySexoEquals(String sexo);

    @Query("SELECT d FROM Donator d WHERE d.tipo_sanguineo = :tipoSangue")
    List<Donator> allBySangue(String tipoSangue);

    @Query("SELECT d FROM Donator d WHERE d.peso > 50")
    List<Donator> pesoMaior50();
}