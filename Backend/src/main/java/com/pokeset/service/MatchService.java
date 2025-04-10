package com.pokeset.service;

import com.pokeset.model.MatchRequestWrapper;
import com.pokeset.model.BaseResponse;

public interface MatchService {
    BaseResponse<Object> postRegisterMatch(MatchRequestWrapper matchRequestWrapper);
}
