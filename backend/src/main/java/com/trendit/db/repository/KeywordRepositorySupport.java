package com.trendit.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trendit.api.response.data.KeywordData;
import com.trendit.db.entity.Keyword;
import com.trendit.db.entity.QKeyword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class KeywordRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    QKeyword qKeyword = QKeyword.keyword1;

    public List<KeywordData> getKeywordList(String keyword) {
        List<Keyword> sql_list = jpaQueryFactory.select(qKeyword)
                .from(qKeyword)
                .where(qKeyword.keyword.like(keyword + "%"))
                .fetch();

        List<KeywordData> ret_list = new ArrayList<>();

        for (Keyword k : sql_list) {
            if (k.getCompany() != null)
                ret_list.add(new KeywordData(k.getKeywordId(), k.getKeyword(), k.getCompany().getCompanyId()));
            else
                ret_list.add(new KeywordData(k.getKeywordId(), k.getKeyword(), 0));
        }
        return ret_list;
    }

    public KeywordData getKeyword(long keyword_id) {
        Keyword data = jpaQueryFactory.select(qKeyword)
                .from(qKeyword)
                .where(qKeyword.keywordId.eq(keyword_id))
                .fetchOne();

        KeywordData ret;
        if (data.getCompany() != null)
            ret = new KeywordData(data.getKeywordId(), data.getKeyword(), data.getCompany().getCompanyId());
        else
            ret = new KeywordData(data.getKeywordId(), data.getKeyword(), 0);

        return ret;
    }

}
