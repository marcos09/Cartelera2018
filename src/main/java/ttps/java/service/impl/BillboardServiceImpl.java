package ttps.java.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.java.dto.BillboardDTO;
import ttps.java.entity.Billboard;
import ttps.java.repository.BillboardRepository;
import ttps.java.service.BillboardService;

@Service
@Transactional
public class BillboardServiceImpl extends GenericServiceImpl<BillboardRepository, Billboard, BillboardDTO> implements BillboardService {

}
