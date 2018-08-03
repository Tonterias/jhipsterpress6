package web.jhp6.web.service.impl;

import web.jhp6.web.service.UrllinkService;
import web.jhp6.web.domain.Urllink;
import web.jhp6.web.repository.UrllinkRepository;
import web.jhp6.web.service.dto.UrllinkDTO;
import web.jhp6.web.service.mapper.UrllinkMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Service Implementation for managing Urllink.
 */
@Service
@Transactional
public class UrllinkServiceImpl implements UrllinkService {

    private final Logger log = LoggerFactory.getLogger(UrllinkServiceImpl.class);

    private final UrllinkRepository urllinkRepository;

    private final UrllinkMapper urllinkMapper;

    public UrllinkServiceImpl(UrllinkRepository urllinkRepository, UrllinkMapper urllinkMapper) {
        this.urllinkRepository = urllinkRepository;
        this.urllinkMapper = urllinkMapper;
    }

    /**
     * Save a urllink.
     *
     * @param urllinkDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UrllinkDTO save(UrllinkDTO urllinkDTO) {
        log.debug("Request to save Urllink : {}", urllinkDTO);
        Urllink urllink = urllinkMapper.toEntity(urllinkDTO);
        urllink = urllinkRepository.save(urllink);
        return urllinkMapper.toDto(urllink);
    }

    /**
     * Get all the urllinks.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UrllinkDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Urllinks");
        return urllinkRepository.findAll(pageable)
            .map(urllinkMapper::toDto);
    }



    /**
     *  get all the urllinks where Post is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<UrllinkDTO> findAllWherePostIsNull() {
        log.debug("Request to get all urllinks where Post is null");
        return StreamSupport
            .stream(urllinkRepository.findAll().spliterator(), false)
            .filter(urllink -> urllink.getPost() == null)
            .map(urllinkMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one urllink by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UrllinkDTO> findOne(Long id) {
        log.debug("Request to get Urllink : {}", id);
        return urllinkRepository.findById(id)
            .map(urllinkMapper::toDto);
    }

    /**
     * Delete the urllink by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Urllink : {}", id);
        urllinkRepository.deleteById(id);
    }
}
