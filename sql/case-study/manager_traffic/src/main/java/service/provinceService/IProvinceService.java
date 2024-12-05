package service.provinceService;

import model.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> showAllProvinces();
    boolean createProvince(Province province);
    boolean updateProvince(Province province);
    boolean deleteProvince(int code);
    Province findProvinceById(int id);
}
