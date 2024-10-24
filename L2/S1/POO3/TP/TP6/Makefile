# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2024/10/24 11:03:06 by inazaria          #+#    #+#              #
#    Updated: 2024/10/24 11:39:18 by inazaria         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

SRC_DIR = ./src/
BUILD_DIR = ./build/

SRC_FILE_NAMES = Main.java
SRC_FILE_NAMES += Forme.java
SRC_FILE_NAMES += Rectangle.java
SRC_FILE_NAMES += Ellipse.java

SRC_FILES = $(addprefix $(SRC_DIR), $(SRC_FILE_NAMES));
CLASS_FILES = $(patsubst $(SRC_DIR)%.java, $(BUILD_DIR)%.class, $(SRC_FILES))

NAME = TP6
MKDIR = mkdir -p
RM_RF = rm -rf
JAVAC = javac
ECHO = echo -e


BLUE	:= \e[34m
BROWN	:= \e[33m
GREEN	:= \e[32m
RED		:= \e[31m
NC		:= \e[0m

$(BUILD_DIR)%.class : $(SRC_DIR)%.java
	@cd $(SRC_DIR)
	echo "SRC_DIR: $(SRC_DIR)"
	@$(MKDIR) $(dir $@)
	@$(ECHO) "$(BLUE)[CMP] Compiling $< into $@...$(NC)"
	@$(JAVAC) $< -d $(dir $@)

$(NAME) : $(CLASS_FILES)
	@echo $(CLASS_FILES)
	@$(ECHO) "$(BROWN)[BLD] Running .class files in the JVM...$(NC)"
	@java $(CLASS_FILES)
	
clean :
	@$(ECHO) "$(BROWN)[CLN] Cleaning class files...$(NC)"
	@$(RM_RF) $(BUILD_DIR)/*
	@$(ECHO) "$(GREEN)[CLN] Clean complete.$(NC)"

fclean :
	@$(ECHO) "$(BROWN)[CLN] Cleaning class files and build directory...$(NC)"
	@$(RM_RF) $(BUILD_DIR)
	@$(ECHO) "$(GREEN)[CLN] Clean complete.$(NC)"

re : fclean $(NAME)

.DEFAULT_GOAL := $(NAME)
.SUFFIXES : .java .class
.PHONY : $(NAME) clean fclean re
