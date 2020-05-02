package com.example.demo.services;

import com.example.demo.models.entities.TriviaGameEntity;
import com.example.demo.models.entities.UsersEntity;
import com.example.demo.payload.request.UserRequest;
import com.example.demo.payload.response.UpdateUserResponse;
import com.example.demo.payload.response.UserResponse;
import com.example.demo.repository.TriviaGameRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TriviaGameServiceImpl implements TriviaGameService {
    private final TriviaGameRepository triviaGameRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public TriviaGameServiceImpl(TriviaGameRepository triviaGameRepository, UsersRepository usersRepository) {
        this.triviaGameRepository = triviaGameRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<TriviaGameEntity> getQuestionsList() {

        triviaGameRepository.save(new TriviaGameEntity(1, "מה עושה סלק כשנמאס לו מחבר שלו?", "מסלק_אותו", "אותו", 0, "מ-סלק אותו"));
        triviaGameRepository.save(new TriviaGameEntity(2, "מה דבר ראשון אמרתי ל-ורה כשביקשתי  אלוורה בטלפון?", "הלו_ורה", "ורה", 0, "יפה! הלו ורה / אלוורה"));
        triviaGameRepository.save(new TriviaGameEntity(3, "מה אמרתי לקומקום כשהרגשתי שהוא רדום ולא עובד טוב?", "קום_קום", "קו", 0, "קום קום / קומקום"));
        triviaGameRepository.save(new TriviaGameEntity(4, "איזה כרוב אוכלים בשטחים?", "כרוב_כבוש", "כרוב", 0, ""));
        triviaGameRepository.save(new TriviaGameEntity(5, "מה שאלתי מטאט שחשב שהוא תה?", "מה_אתה_תה", "תה", 0, "מה אתה תה / מטאטא"));
        triviaGameRepository.save(new TriviaGameEntity(6, "איך קוראים לחייט שעושה בגדים למסיבות?", "חיית_מסיבות", "חיית", 0, "חייט מסיבות / חיית מסיבות"));
        triviaGameRepository.save(new TriviaGameEntity(7, "אילו אנשים מהמשפחה תנין סבא רבא הלך לבקר?", "תנינים", "תנ", 0, "תנינים / ת'נינים"));
        triviaGameRepository.save(new TriviaGameEntity(8, "איזה לאפה אוכלים האוהדים באצטדיון טדי?", "לאפה_מיליה", "לאפה", 2, "לאפה מיליה / לה פמיליה"));
        triviaGameRepository.save(new TriviaGameEntity(9, "מה אומרים כשמקבלים מייל נוסף מהודי?", "הודי_מייל", "הודי", 1, "הודי מייל / עוד אי מייל"));
        triviaGameRepository.save(new TriviaGameEntity(10, "מה אומרים באפריל כשלא מתאים לאכול את הפרי", "אפריל_לא_מתאים", "אפריל", 2, "אפריל לא מתאים / הפרי לא מתאים"));
        triviaGameRepository.save(new TriviaGameEntity(11, "איך חצילים עושים חצי חצי?", "חציל_לי_חציל_לך", "חציל", 0, "חציל לי חציל לך / חצי לי חצי לך"));
        triviaGameRepository.save(new TriviaGameEntity(12, "מה המשפט הכי נפוץ של מלצר במסעדת מלבי?", "מה_להביא_לך", "להביא", 0, "מלבי לך / מה להביא לך"));
        triviaGameRepository.save(new TriviaGameEntity(13, "מאיזה מים אסירים הכי מפחדים?", "מים_סוהרים", "מים", 1, "מים סוהרים / מים סוערים"));
        triviaGameRepository.save(new TriviaGameEntity(14, "מה אומרים בותיקן כשהזקן הגיע? ", "הותיק_כאן", "כאן", 0, "הותיק כאן / הותיקן"));
        triviaGameRepository.save(new TriviaGameEntity(15, "איזה שפה דיבר רית כשהוא אמר משהו?", "אמהרית", "אמ", 1, "אמהרית / אמר רית"));
        triviaGameRepository.save(new TriviaGameEntity(16, "מה שאל עובד במעריב כשהוא ראה שני עובדים רבים?", "על_מה_הריב", "הריב", 1, "על מה הריב /  על מעריב"));
        triviaGameRepository.save(new TriviaGameEntity(17, "מה אמר מחבל מתאבד כששבע מהאוכל?", "התפוצצתי", "הת", 0, ""));
        triviaGameRepository.save(new TriviaGameEntity(18, "מה עושה מישהו שמדבר שפה באופן רהוט ושוטף כלים תוך כדי?", "מדבר_שוטף", "שוטף", 2, "מדבר רהוט + שוטף כלים = מדבר שוטף"));
        triviaGameRepository.save(new TriviaGameEntity(19, "מה עשה מישהו שגם שם שלטים וגם תלש אותם?", "תלה_שלטים", "שלטים", 1, " תלה שלטים / תלש שלטים"));
        triviaGameRepository.save(new TriviaGameEntity(20, "מה הדרך הכי פשוטה לשרוף את חברת צים?", "לשרוף_עצים", "לשרוף", 1, "לשרוף עצים / לשרוף את צים"));
        triviaGameRepository.save(new TriviaGameEntity(21, "מה שאלתי מישהי כשרציתי חוט וגם רציתי לדעת מה מצב הרטיבות בחוץ?", "יש_לך_חוט", "יש", 0, " יש לך חוט / יש לחות"));
        triviaGameRepository.save(new TriviaGameEntity(22, "איך קוראים לארבעה אנשים שאפשר לסמוך עליהם וגם שמברכים עליהם בסוכות?", "ארבעת_המינים", "המינים", 0, "ארבעת אמינים / ארבעת המינים"));
        triviaGameRepository.save(new TriviaGameEntity(23, "מה אומרים כשכלה נוסעת בכביש והפקקים משתחררים?", "הכלה_בפקקים", "הכלה", 1, "הכלה בפקקים / הקלה בפקקים"));
        triviaGameRepository.save(new TriviaGameEntity(24, "מה אמר גבר לאשתו שהרביצה לו וגם גילה שהיא לא אוהדת הפועל?", "את_מכה_בי", "בי", 2, "יפה! את מכה בי / את מכבי"));
        triviaGameRepository.save(new TriviaGameEntity(25, "מה אומרים על סוג של חציל שהוא לא טוב וגם בא לבקר בבית", "בלדי_רע", "בלדי", 2, "בלדי רע / בא לדירה"));
        triviaGameRepository.save(new TriviaGameEntity(26, "איך מגדירים מישהו בשם מתן שגם אוהב לתרום וגם אוהב להתחבא?", "מתן_בסתר", "מתן", 1, ""));
        triviaGameRepository.save(new TriviaGameEntity(27, "אם גם למדתי וגם חזרתי מאירוע מקדים לחתונה מאיפה באתי?", "מחינה", "מח", 2, "מחינה / מכינה"));
        triviaGameRepository.save(new TriviaGameEntity(28, "מה אמרתי לנציג סנו שלא נסע בכביש?", "סע_נו", "סע", 1, "סע נו / סנו"));
        triviaGameRepository.save(new TriviaGameEntity(29, "איך אומן חושים שמן משפיע עליך?", "בטט_מודע", "בטט", 2, "בטט מודע / בתת מודע"));
        triviaGameRepository.save(new TriviaGameEntity(30, "איך קוראים לקשר בין עבד למעביד שלו כשלמעביד קוראים רות?", "יחסי_מר_רות", "רות", 1, "יחס מר רות / יחסי מרות"));
        triviaGameRepository.save(new TriviaGameEntity(31, "מה אומרים על מישהו שמצופה בסוכר וגם מופיע בתקשורת?", "מסוקר", "מס", 1, "מסוקר / מסוכר"));


        List<TriviaGameEntity> result = triviaGameRepository.findAll();
        return result;
    }

    @Override
    public Integer registerUser(UserRequest userRequest) {
        UsersEntity user = usersRepository.save(new UsersEntity(userRequest.getName(), userRequest.getScore(), userRequest.getNumberOfAnswerQuestions()));
        return user.getId();
    }

    @Override
    public UpdateUserResponse updateUser(UserRequest userRequest) {
        UpdateUserResponse response = UpdateUserResponse.builder().build();
        try {
            UsersEntity usersEntity =
                    UsersEntity.builder()
                            .id(userRequest.getId())
                            .name(userRequest.getName())
                            .score(userRequest.getScore())
                            .numberOfAnswerQuestions(userRequest.getNumberOfAnswerQuestions()).build();
            usersRepository.save(usersEntity);
        } catch (DataIntegrityViolationException e) {
            response.setMessage("User update failed.");
        }

        return response;
    }

    @Override
    public List<UsersEntity> getUsers() {
        List<UsersEntity> users = usersRepository.findAll();
        return users;
    }
}


