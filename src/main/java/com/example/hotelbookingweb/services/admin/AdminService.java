package com.example.hotelbookingweb.services.admin;

import com.example.hotelbookingweb.repositories.GuestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final GuestsRepository guestsRepository;

    @Transactional
    public void delete(int id) {
        guestsRepository.deleteById(id);
    }
}
