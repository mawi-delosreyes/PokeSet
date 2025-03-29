package com.pokeset.service;

import com.pokeset.model.MatchRequestWrapper;
import com.pokeset.model.Response;

public interface MatchService {
    Response<Object> postRegisterMatch(MatchRequestWrapper matchRequestWrapper);
}
