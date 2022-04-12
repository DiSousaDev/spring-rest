package br.dev.diego.springrest.services;

import br.dev.diego.springrest.entities.User;
import br.dev.diego.springrest.entities.dto.UserDto;
import br.dev.diego.springrest.entities.dto.UserInsertDto;
import br.dev.diego.springrest.entities.mapper.UserMapper;
import br.dev.diego.springrest.repositories.UserRepository;
import br.dev.diego.springrest.services.exceptions.DatabaseException;
import br.dev.diego.springrest.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public Page<UserDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(user -> userMapper.userToUserDto(user));
    }

    @Transactional
    public UserDto save(UserInsertDto userInsertDto) {
        User user = userMapper.userInsertDtoToUser(userInsertDto);
        user = repository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Erro ao excluir! Id [" + id + "] não encontrado.");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Usuário id [" + id + "] não pode ser excluido.");
        }
    }

    @Transactional(readOnly = true)
    public Page<UserDto> findByName(String name, Pageable pageable) {
        return repository.findByName(name.trim(), pageable).map(user -> userMapper.userToUserDto(user));
    }
}
