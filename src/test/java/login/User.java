package login;

import java.io.Serializable;

public class User implements Serializable {
        /** Serial Version UID */
        private static final long serialVersionUID = 1L;

        private String username = null;

        private String userpassword = null;
        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }
        /**
         * @param username the username to set
         */
        public void setUsername(String username) {
            this.username = username;
        }
        /**
         * @return the userpassword
         */
        public String getUserpassword() {
            return userpassword;
        }
        /**
         * @param userpassword the userpassword to set
         */
        public void setUserpassword(String userpassword) {
            this.userpassword = userpassword;
        }
    }
