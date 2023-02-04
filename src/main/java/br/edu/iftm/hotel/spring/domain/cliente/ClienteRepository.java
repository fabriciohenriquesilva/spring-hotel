package br.edu.iftm.hotel.spring.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository<T extends Cliente> extends JpaRepository<T, Long> {
}
