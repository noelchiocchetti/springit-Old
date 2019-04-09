package com.chiocchetti.springit.repository;

import com.chiocchetti.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {


}
