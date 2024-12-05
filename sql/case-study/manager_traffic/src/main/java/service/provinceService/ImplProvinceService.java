package service.provinceService;

import model.Province;
import repository.provinceRepository.ImplProvinceRepository;

import java.util.Collections;
import java.util.List;

public class ImplProvinceService implements IProvinceService{
    ImplProvinceRepository implProvinceRepository = new ImplProvinceRepository();
    @Override
    public List<Province> showAllProvinces() {
        List<Province> provincesList  = null;
        provincesList = implProvinceRepository.showAllProvinces();
        return provincesList;
    }

    @Override
    public boolean createProvince(Province province) {
        boolean result = implProvinceRepository.createProvince(province);
        return result;
    }

    @Override
    public boolean updateProvince(Province province) {
        boolean result = implProvinceRepository.updateProvince(province);
        return result;
    }

    @Override
    public boolean deleteProvince(int code) {
        boolean result = implProvinceRepository.deleteProvince(code);
        return result;
    }

    @Override
    public Province findProvinceById(int id) {
        Province province = null;
        province=implProvinceRepository.findProvinceById(id);
        return province;
    }
}
