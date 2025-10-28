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
     * Lấy danh sách tất cả cơ sở vật chất từ database.
     * @return List<CoSoVatChat>
     */
    public List<CoSoVatChat> layTatCaCoSoVatChat() {
        return coSoVatChatRepository.findAll();
    }

    /**
     * Tìm cơ sở vật chất theo ID.
     * @param id ID của cơ sở vật chất.
     * @return Optional<CoSoVatChat>
     */
    public Optional<CoSoVatChat> timTheoId(int id) {
        return coSoVatChatRepository.findById(id);
    }

    /**
     * Lưu (tạo mới hoặc cập nhật) một đối tượng CoSoVatChat.
     * Đây là nơi chứa logic nghiệp vụ (business logic).
     * @param coSoVatChat Đối tượng cần lưu.
     * @return Đối tượng đã được lưu (với tongDiem đã được cập nhật).
     */
    @Transactional
    public CoSoVatChat luuCoSoVatChat(CoSoVatChat coSoVatChat) {
        // --- LOGIC NGHIỆP VỤ ---
        // Luôn luôn tính toán lại tổng điểm mỗi khi lưu
        // để đảm bảo dữ liệu nhất quán.
        int tongDiem = coSoVatChat.tinhTongDiem();
        coSoVatChat.setTongDiem(tongDiem);
        // -------------------------
        
        return coSoVatChatRepository.save(coSoVatChat);
    }

    /**
     * Xóa cơ sở vật chất theo ID.
     * @param id ID của cơ sở vật chất cần xóa.
     */
    public void xoaCoSoVatChat(int id) {
        coSoVatChatRepository.deleteById(id);
    }
    
    // Bạn có thể thêm các phương thức logic nghiệp vụ khác ở đây
    // ví dụ: timCoSoVatChatTheoTruong(int truongId), ...
}
