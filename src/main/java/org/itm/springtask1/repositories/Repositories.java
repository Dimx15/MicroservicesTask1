package org.itm.springtask1.repositories;

import org.itm.springtask1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositories extends JpaRepository<User, Integer> { }
