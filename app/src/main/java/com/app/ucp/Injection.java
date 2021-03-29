package com.app.ucp;

import com.app.ucp.data.AddPerfumeRepository;
import com.app.ucp.data.BottleShapeRepository;
import com.app.ucp.data.BottleSizeRepository;
import com.app.ucp.data.CategoryRepository;
import com.app.ucp.data.FragranceConcentrationRepository;
import com.app.ucp.data.FragranceFamilyRepository;
import com.app.ucp.data.PerfumeSearchRepository;
import com.app.ucp.domain.AddPerfumeRepositoryImpl;
import com.app.ucp.domain.BottleShapeRepositoryImpl;
import com.app.ucp.domain.BottleSizesRepositoryImpl;
import com.app.ucp.domain.CategoryRepositoryImpl;
import com.app.ucp.domain.FragranceConcentrationRepositoryImpl;
import com.app.ucp.domain.FragranceFamilyRepositoryImpl;
import com.app.ucp.domain.PerfumeSearchRepositoryImpl;
import com.app.ucp.domain.usecases.AddPerfumeUseCase;
import com.app.ucp.domain.usecases.PerfumeSearchUseCase;
import com.app.ucp.domain.usecases.RetrieveBottleShapesUseCase;
import com.app.ucp.domain.usecases.RetrieveCategoriesUseCase;
import com.app.ucp.domain.usecases.RetrieveFragranceFamilyUseCase;
import com.app.ucp.domain.usecases.RetrieveFragranceUseCase;
import com.app.ucp.domain.usecases.RetrievePerfumesByCategoryUseCase;
import com.app.ucp.domain.usecases.RetriveBottleSizesUseCase;

public class Injection {
    public static RetrieveFragranceUseCase getRetrieveFragranceUsceCase() {
        return new RetrieveFragranceUseCase(getFragranceConcentrationRepository());
    }

    private static FragranceConcentrationRepository getFragranceConcentrationRepository() {
        return new FragranceConcentrationRepositoryImpl();
    }

    public static RetrieveCategoriesUseCase getRetrieveCategoriesUseCase() {
        return new RetrieveCategoriesUseCase(getCategoryRepository());
    }

    private static CategoryRepository getCategoryRepository() {
        return new CategoryRepositoryImpl();
    }

    public static RetrievePerfumesByCategoryUseCase getRetrievePerfumesByCategoryUseCase() {
        return new RetrievePerfumesByCategoryUseCase(getFragranceFamilyRepository());
    }

    private static FragranceFamilyRepository getFragranceFamilyRepository() {
        return new FragranceFamilyRepositoryImpl();
    }

    public static RetrieveFragranceFamilyUseCase getFragranceFamilyUseCase() {
        return new RetrieveFragranceFamilyUseCase(getFragranceFamilyRepository());
    }

    public static RetriveBottleSizesUseCase getRetrieveBottleSizesUseCase() {
        return new RetriveBottleSizesUseCase(getBottleSizeRepository());
    }

    private static BottleSizeRepository getBottleSizeRepository() {
        return new BottleSizesRepositoryImpl();
    }

    public static RetrieveBottleShapesUseCase getRetrieveBottleShapesUseCase() {
        return new RetrieveBottleShapesUseCase(getBottleShapeRepoistory());
    }

    private static BottleShapeRepository getBottleShapeRepoistory() {
        return new BottleShapeRepositoryImpl();
    }

    public static AddPerfumeUseCase getAddPerfumeUseCase() {
        return new AddPerfumeUseCase(getAddPerfumeRepositroy());
    }

    private static AddPerfumeRepository getAddPerfumeRepositroy() {
        return new AddPerfumeRepositoryImpl();
    }

    public static PerfumeSearchUseCase getPerfumeSearchUseCase() {
        return new PerfumeSearchUseCase(getPerfumeSearchRepository());
    }

    private static PerfumeSearchRepository getPerfumeSearchRepository() {
        return new PerfumeSearchRepositoryImpl();
    }
}
