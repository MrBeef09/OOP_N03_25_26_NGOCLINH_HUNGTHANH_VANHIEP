package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.Model.Truongdaihoc.CoSoVatChat;
import com.example.servingwebcontent.Repository.CoSoVatChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CoSoVatChatService {

    @Autowired
    private CoSoVatChatRepository coSoVatChatRepository;

    /**
     * Lấy toàn bộ danh sách cơ sở vật chất.
     */
    public List<CoSoVatChat> layTatCaCoSoVatChat() {
        return coSoVatChatRepository.findAll();
    }

    /**
     * Tìm cơ sở vật chất theo ID.
     */
    public Optional<CoSoVatChat> timTheoId(int id) {
        return coSoVatChatRepository.findById(id);
    }

    /**
     * Thêm mới cơ sở vật chất.
     */
    @Transactional
    public CoSoVatChat themCoSoVatChat(CoSoVatChat coSoVatChat) {
        // Logic nghiệp vụ: tính lại tổng điểm
        coSoVatChat.setTongDiem(coSoVatChat.tinhTongDiem());
        return coSoVatChatRepository.save(coSoVatChat);
    }

    /**
     * Cập nhật thông tin cơ sở vật chất (nếu tồn tại).
     */
    @Transactional
    public CoSoVatChat capNhatCoSoVatChat(int id, CoSoVatChat coSoVatChatMoi) {
        Optional<CoSoVatChat> coSoCu = coSoVatChatRepository.findById(id);

        if (coSoCu.isPresent()) {
            CoSoVatChat coSo = coSoCu.get();
            coSo.setSoPhongHoc(coSoVatChatMoi.getSoPhongHoc());
            coSo.setSoKyTucXa(coSoVatChatMoi.getSoKyTucXa());
            coSo.setSoThuVien(coSoVatChatMoi.getSoThuVien());
            coSo.setSoTrangThietBi(coSoVatChatMoi.getSoTrangThietBi());
            coSo.setSoTienIch(coSoVatChatMoi.getSoTienIch());
            coSo.setSoHaTangKiThuat(coSoVatChatMoi.getSoHaTangKiThuat());

            coSo.setTongDiem(coSo.tinhTongDiem());
            return coSoVatChatRepository.save(coSo);
        } else {
            throw new RuntimeException("Không tìm thấy cơ sở vật chất có ID: " + id);
        }
    }

    /**
     * Xóa cơ sở vật chất theo ID.
     */
    public void xoaCoSoVatChat(int id) {
        if (coSoVatChatRepository.existsById(id)) {
            coSoVatChatRepository.deleteById(id);
        } else {
            throw new RuntimeException("Không thể xóa vì không tìm thấy cơ sở vật chất có ID: " + id);
        }
    }
}
