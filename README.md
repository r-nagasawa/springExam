drop table if exists questions;

CREATE TABLE IF NOT EXISTS questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
   sentence VARCHAR(1024),
    option1_value VARCHAR(10),
    option1_label VARCHAR(512),									
    option2_value VARCHAR(10),									
    option2_label VARCHAR(512),									
    option3_value VARCHAR(10),									
    option3_label VARCHAR(512),									
    option4_value VARCHAR(10),									
    option4_label VARCHAR(512),									
    answer VARCHAR(10)									
);						

insert into questions (																																																				
    sentence,																																																				
    option1_value, option1_label,																																																				
    option2_value, option2_label,																																																				
    option3_value, option3_label,																																																				
    option4_value, option4_label,																																																				
    answer																																																				
) values 																																																				
(																																																				
    '一般用語としては、時代遅れの古い仕組みのことで、情報システムにおいては主に 技術革新による代替技術が広く普及した段階で旧来の技術基盤により構築されているシステムを何と呼ぶか。',																																																				
    'A', 'レガシーシステム',																																																				
    'B', 'ERP',																																																				
    'C', 'トラディショナルシステム',																																																				
    'D', 'メインフレーム',																																																				
    'A'																																																				
),																																																				
(																																																				
    'UNIX系OSにおいてシステム管理者用のアカウントに付与されるほぼすべての操作が可能な権限のことを何と呼ぶか。',																																																				
    'A', 'root権限',																																																				
    'B', 'Administrator権限',																																																				
    'C', 'control権限',																																																				
    'D', 'management権限',																																																				
    'A'																																																				
),																																																				
(																																																				
    '外部への安全なアクセスを実現し、また外部からの不正なアクセスを防ぐ役目を果たすセキュリティを確保するためのしくみのことを何と呼ぶか。',																																																				
    'A', 'アンチウィルス',																																																				
    'B', 'ファイアウォール',																																																				
    'C', 'SOC',																																																				
    'D', 'IDS/IPS',																																																				
    'B'																																																				
);																																																				


