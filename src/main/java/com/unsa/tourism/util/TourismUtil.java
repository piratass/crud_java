package com.unsa.tourism.util;

import com.unsa.tourism.dto.CreateEntityResponseDTO;

public class TourismUtil {
    public static CreateEntityResponseDTO createEntityFromResource(Integer id ,String href){
        CreateEntityResponseDTO createEntityResponseDTO =new CreateEntityResponseDTO();
        createEntityResponseDTO.setId(id);
        createEntityResponseDTO.setHref(href);
        return createEntityResponseDTO;
    }
}
