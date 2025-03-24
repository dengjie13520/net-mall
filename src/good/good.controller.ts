import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { GoodService } from './good.service';
import { CreateGoodDto } from './dto/create-good.dto';
import { UpdateGoodDto } from './dto/update-good.dto';

@Controller('good')
export class GoodController {
  constructor(private readonly goodService: GoodService) {}

  @Post()
  create(@Body() createGoodDto: CreateGoodDto) {
    return this.goodService.create(createGoodDto);
  }

  @Get()
  findAll() {
    return this.goodService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.goodService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateGoodDto: UpdateGoodDto) {
    return this.goodService.update(+id, updateGoodDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.goodService.remove(+id);
  }
}
